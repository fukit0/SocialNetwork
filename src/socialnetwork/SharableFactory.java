package socialnetwork;

public class SharableFactory {

	public SharableObject createShaObj(String data,String type)
	{
		if(type.equals("text"))
			return new SharableText(data);
		else if(type.equals("link"))
			return new SharableLink(data);
		else
			return new SharableMedia(data);
		
	}
}
