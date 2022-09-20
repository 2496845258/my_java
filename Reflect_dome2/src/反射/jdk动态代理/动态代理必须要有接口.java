package 反射.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class 动态代理必须要有接口 {

    public static void main(String[] args) throws Exception {

        //我传入的是具体实现类，这个实现类实现了2个接口
        Hello hello = geiOne(Class.forName("反射.jdk动态代理.HelloImpl"));
        hello.sayHello();
    }
    private static class MyProxy implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //proxy，是你传入的目标接口数组的匿名实现类。
            for ( Class _interface : proxy.getClass().getInterfaces() ) {
                //我们可以看到proxy实现了你刚才传入的接口的class数组
                System.out.println( _interface.getName() );
            }

            //method，当前正在执行的方法，也可以说是被拦截的方法。
            System.out.println( "当前正在执行的方法 " + method.getName() );

            //args，被拦截的方法传入的参数
            //注意，proxy不要去调任何方法，因为他执行的方法会被拦截捕捉，然后形成，递归调用。
            //比如 proxy.toString() 或 method.invoke(proxy, args);

            //动态代理原理是：拦截任何代理实现类的调用。上面的代码已经表面了我proxy本身是代理实现类。这个代理实现类只有一个方法
            //proxy调用的所有方法都变成了调一个方法，去调用proxy里的invoke。所以你才不能让proxy在invoke方法里面调用任何方法
            //Proxy.newProxyInstance(....) 动态代理返回的对象，返回的就是proxy

            return null;
        }
    }

    public static <T> T geiOne(Class clazz) {
        //我的动态代理类。当然，其实你不用这么写也许，直接去写lambad表达式也许，3参一返回。
        //我自定义动态代理类只是为了更好的解释参数
        MyProxy myProxy = new MyProxy();
        Class[] css = null;
        if ( clazz.isInterface() ) {
            //返回被代理对象，假设动态代理的目标是接口，那么jdk会提供一个的匿名实现类。返回给接口的就是匿名实现类。
            //被代理对象的所有方法的执行都会被拦截。代理方法返回的是Object（反正java是单返回，你可以返回一切东西）
            css = new Class[]{clazz};
        } else {
            //如果传进来是具体类，那我就得获取他的接口数组
            css = clazz.getInterfaces();
            if ( null == css || css.length < 1 ) {
                //因为你传的是字符串，没有接口，的实现类，不能代理
                return null;
            }
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), css, myProxy::invoke);
        // "返回值必须用接口回调"。因为这个返回值就是动态代理方法里面的的参数proxy，是接口的匿名实现类。
        // Proxy.newProxyInstance( "一个类加载器（最好是目标对象的）", "接口的class对象数组", "动态代理的拦截方法");
    }
}
