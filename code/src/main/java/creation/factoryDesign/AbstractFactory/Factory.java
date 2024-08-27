package creation.factoryDesign.AbstractFactory;



interface AbstractFactory{
    Button createButton();
    Dialog createDialog();
}

class WindowsFactory implements AbstractFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Dialog createDialog() {
        return new WindowsDialog();
    }
}

class IosFactory implements AbstractFactory{

    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public Dialog createDialog() {
        return new WindowsDialog();
    }
}


