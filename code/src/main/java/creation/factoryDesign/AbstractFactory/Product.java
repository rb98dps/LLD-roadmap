package creation.factoryDesign.AbstractFactory;

public interface Product {
}

interface Button extends Product{

}
interface Dialog extends Product{

}

class IosButton implements Button {

}
class WindowsButton implements Button{

}

class IosDialog implements Dialog{

}
class WindowsDialog implements Dialog{

}
