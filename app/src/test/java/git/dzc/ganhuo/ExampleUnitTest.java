package git.dzc.ganhuo;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import git.dzc.ganhuo.type.DataType;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void test(){
//        System.out.println(Arrays.toString(DataType.class.getGenericInterfaces()));
        Observable<String> observableHello = Observable.just(helloWorld());

        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("ddddd");
                subscriber.onCompleted();
            }
        }).filter(b-> b.startsWith("ddd")).doOnCompleted(()->{
            System.out.println("doOnComplete");
        })
//                .concatWith(observableHello)
//                .mergeWith(observableHello)
//                .mergeWith(observableHello)
                .ambWith(observableHello);
//        observable.subscribe();
//        Subscription subscription = observable.subscribe(s -> {
//            System.out.println(s);
//        }, a->{}, () -> System.out.println("oncomplete"));

        Observable.defer(()-> Observable.create(subscriber1 -> {
            System.out.println("deeee");
            subscriber1.onCompleted();
        })).subscribe();

    }

    private Observable<Object> o() {
        Observable o = Observable.create(subscriber1 -> {
            System.out.println("deeee");
            subscriber1.onCompleted();
        });
        return o;
    }

    public String helloWorld(){
        System.out.println("hello world");
        return "hello";
    }

    public void f(List<String> list){
        Collections.sort(list,(s1,s2)->s1.compareTo(s2));
    }
}