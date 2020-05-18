package com.design.demo.builder;

import lombok.ToString;

import java.util.stream.Stream;

/**
 *  具有多个参数时，使用建造者模式
 */
@ToString
public class MoreArgsBuilder {

    private String name;
    private String age;
    private String gender;
    private String addr;
    private String fixed; // 必需参数

    private MoreArgsBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.gender = builder.gender;
        this.addr = builder.addr;
        this.fixed = builder.fixed;
    }

    // 创建内部类
    public static class Builder {
        private String name;
        private String age;
        private String gender;
        private String addr;
        private String fixed;

        public Builder(String fixed) {
            this.fixed = fixed;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder addr(String addr) {
            this.addr = addr;
            return this;
        }

        public MoreArgsBuilder builder() {
            return new MoreArgsBuilder(this);
        }
    }
}

class TestM2 {
    public static void main(String[] args) {
        MoreArgsBuilder builder = new MoreArgsBuilder.Builder("固定参数")
                .name("小吴")
                .age("18")
                .gender("女")
                .addr("湖北武汉")
                .builder();
        System.out.println(builder);
    }
}
