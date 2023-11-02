package de.iteratec.kotlin.basic;

class SimpleClassJava {
    private String readOnlyProperty;
    public String getReadOnlyProperty() {
        return readOnlyProperty;
    }

    private Integer mutableProperty;
    public void setMutableProperty(Integer mutableProperty) {
        this.mutableProperty = mutableProperty;
    }
    public Integer getMutableProperty() {
        return mutableProperty;
    }

    public SimpleClassJava(String readOnlyProperty, Integer mutableProperty) {
        System.out.println("In constructor");
        this.readOnlyProperty = readOnlyProperty;
        this.mutableProperty = mutableProperty;
    }

    public void method() {
        System.out.println(this);
    }
}
