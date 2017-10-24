package com.test.springdata.page;


/**
 * @author Yeager
 *
 * 排序基类
 */
public class SimpleOrder {

    /**
     * 排序属性
     */
    private String property;

    /**
     * 排序方式
     */
    private OrderMode orderMode = OrderMode.ASC;

    /**
     * 排序方式
     */
    public enum OrderMode{
        //顺序
        ASC,
        //倒序
        DESC
    }

    public SimpleOrder() {
    }

    public SimpleOrder(String property, OrderMode orderMode) {
        this.property = property;
        this.orderMode = orderMode;
    }

    public SimpleOrder(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public OrderMode getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(OrderMode orderMode) {
        this.orderMode = orderMode;
    }

    @Override
    public String toString() {
        return "SimpleOrder{" +
            "property='" + property + '\'' +
            ", orderMode=" + orderMode +
            '}';
    }
}
