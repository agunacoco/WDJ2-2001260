package wdj_210325;

public class MyResource implements AutoCloseable{
	public MyResource() {
		System.out.println("MyResource 생성");
		
	}
	public int getValue() throws OutOfResourcesException {
		int random = (int)(Math.random()*2);
		if(random == 0)
		{
			throw new OutOfResourcesException("자원 고갈 오류");
		}
		return (int)(Math.random()*100);
	}
	public void close() {
		System.out.println("close... 자원 반납");
	}

}
