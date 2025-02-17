package ch13.sec02.exam01;

//제네릭 타입
public class Product<k, M> {
	// 필드
	private k kind;
	private M model; 
	
	// 메소드 
	public k getKind() { return this.kind; }
    public M getModel() { return this.model; }
	public void setKind(k kind) { this.kind = kind; }
	public void setModel(M model) { this.model = model; }
}

