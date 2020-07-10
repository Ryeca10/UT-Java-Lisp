import java.util.HashMap;
//interface Functor { Object fn(Object x); }

public class Memoizer 
{
	Functor func;
	HashMap <Object, Object> hm = new HashMap <Object,Object>();
	
	public Memoizer(Functor f)
	{
		func = f;
	}
	
	
	
	public static int fcount = 0;
	 final Functor myf = new Functor()
     { public Object fn (Object x)
         { fcount++;
           return Math.sqrt((Double) x); }};
           
           
	public Object call(Object x)
	{
		if (hm.containsValue(x))
			return hm.get(x);
		else
		{
		  hm.put(x, func.fn(x));
		  return func.fn(x);
		}
	}
	
}
