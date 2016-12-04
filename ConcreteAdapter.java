public class ConcreteAdapter extends ConcreteCommand implements Adapter
{
    ConcreteCommand c;
    public void getConcreteCommand(HostButtonReceiver hbr)
    {
        c = new ConcreteCommand();
        c.setReceiver(hbr);
    }
}
