package com.shengsiyuan._08_innerclass;
//https://www.jianshu.com/p/45efbca72140
interface DelegateApiJava {
    void doSomething();
}

class ImplJava implements DelegateApiJava {

    private DelegateApiJava delegateApiJava;

    public ImplJava(DelegateApiJava delegateApiJava) {
        this.delegateApiJava = delegateApiJava;
    }

    @Override
    public void doSomething() {
        if (this.delegateApiJava != null) {
            System.out.println("before");
            delegateApiJava.doSomething();
            System.out.println("after");
        }
    }
}

public class Delegate {
    public static void main(String[] args) {
        ImplJava implJava = new ImplJava(new DelegateApiJava() {
            @Override
            public void doSomething() {
                System.out.println("doSomething");
            }
        });

        implJava.doSomething();
    }
}

