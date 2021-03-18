package ch.jmildner.k07threads.u6mailbox;

public class U62Producer1 implements Runnable
{
    U61Mailbox mailbox;

    int nummernKreis;

    U62Producer1(U61Mailbox mailbox, int nummernKreis)
    {
        this.mailbox = mailbox;
        this.nummernKreis = nummernKreis;
    }

    @Override
    public void run()
    {
        for (int i = 1; i <= 10; i++)
        {
            setMessage("message-" + nummernKreis + "-" + i);
        }
        setMessage("end-of-message-" + nummernKreis);
    }

    private void setMessage(String s)
    {
        mailbox.setMessage(s);
    }
}

