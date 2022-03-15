package com.example;

import com.example.AdapterPattern.AdapterPatternDemo;
import com.example.BridgePattern.BridgePatternDemo;
import com.example.DecoratorPattern.DecoratorPatternDemo;
import com.example.SingletonPattern.SinglePatternDemo;
import com.example.PrototypePattern.PrototypePatternDemo;
import com.example.FactoryPattern.FactoryPatternDemo;
import com.example.BuilderPattern.BuilderPatternDemo;
import com.example.CompositePattern.CompositePatternDemo;
import com.example.FilterPattern.CriteriaPatternDemo;
import com.example.FacadePattern.FacadePatternDemo;
import com.example.FlyweightPattern.FlyweightPatternDemo;
import com.example.ProxyPattern.ProxyPatternDemo;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // get string from keyboard
        System.out.println("Enter name design pattern: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("Singleton Pattern")) {
            SinglePatternDemo singlePatternDemo = new SinglePatternDemo();
            singlePatternDemo.run();
        }
        if (input.equalsIgnoreCase("Adapter Pattern")) {
            AdapterPatternDemo adapterPatternDemo = new AdapterPatternDemo();
            adapterPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Bridge Pattern")) {
            BridgePatternDemo bridgePatternDemo = new BridgePatternDemo();
            bridgePatternDemo.run();
        }
        if (input.equalsIgnoreCase("Decorator Pattern")) {
            DecoratorPatternDemo decoratorPatternDemo = new DecoratorPatternDemo();
            decoratorPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Prototype Pattern")) {
             PrototypePatternDemo prototypePatternDemo = new PrototypePatternDemo();
            prototypePatternDemo.run();
        }
        if (input.equalsIgnoreCase("Factory Pattern")) {
            FactoryPatternDemo factoryPatternDemo = new FactoryPatternDemo();
            factoryPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Builder Pattern")) {
            BuilderPatternDemo builderPatternDemo = new BuilderPatternDemo();
            builderPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Composite Pattern")) {
            CompositePatternDemo compositePatternDemo = new CompositePatternDemo();
            compositePatternDemo.run();
        }
        if (input.equalsIgnoreCase("Filter Pattern")) {
            CriteriaPatternDemo criteriaPatternDemo = new CriteriaPatternDemo();
            criteriaPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Facade Pattern")){
            FacadePatternDemo facadePatternDemo = new FacadePatternDemo();
            facadePatternDemo.run();
        }
        if (input.equalsIgnoreCase("Flyweight Pattern")){
            FlyweightPatternDemo flyweightPatternDemo = new FlyweightPatternDemo();
            flyweightPatternDemo.run();
        }
        if (input.equalsIgnoreCase("Proxy Pattern")){
            ProxyPatternDemo proxyPatternDemo = new ProxyPatternDemo();
            proxyPatternDemo.run();
        }


    }
}
