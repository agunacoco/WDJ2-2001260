package wdj_210325;

public class OutOfResourcesException extends Exception{
	public OutOfResourcesException() {
		System.out.println("OutOfResourcesException 객체 생성");
	}
	public OutOfResourcesException(String msg) {
		super(msg);
		System.out.println("MtResource 생성");
	}

}
