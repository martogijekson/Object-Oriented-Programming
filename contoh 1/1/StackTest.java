class StackException extends Exception
{
    StackException()
    {}

    StackException(String msg)
    {
        super(msg);
    }
}

class FixedStack
{
    private int capacity;
    private int size;
    private Object[] data;

    public FixedStack(int cap)
    {
        data = new Object[cap];
        capacity = cap;
        size = 0;
    }

    public void push(Object o) throws StackException
    {
        if (size == capacity)
            throw new StackException("overflow");
        data[size++] = o;
    }

	public Object pop() throws StackException
    {
        if (size <= 0)
            throw new StackException("underflow");
        return data[--size];
    }

    public Object top()
        throws StackException
    {
        if (size <= 0)
            throw new StackException("underflow");
        return data[size-1];
    }

    public int size()
    {
        return this.size;
    }
}

public class StackTest
{
    public static void main(String[] args)
    {
        FixedStack s = new FixedStack(3);
        doTest(s);
    }

    public static void doTest(FixedStack s)
    {
        try
        {
            System.out.println("Initial size = " + s.size());
            s.push("one");
            s.push(new Integer(2));
            s.push(new Float(3.0));

            s.push("one too many");  // error!
        }
        catch(StackException x)
        {
            System.out.println(x);
        }

		try
        {
            System.out.println("Top: " + s.top());
            System.out.println("Popping...");

            while (s.size() > 0)
                System.out.println(s.pop());
        }
        catch(StackException x)
        {
            throw new InternalError(x.toString());
        }
    }
}
