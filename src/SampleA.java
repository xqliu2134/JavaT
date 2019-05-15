
public class SampleA {
	public void syncA(String text) {
		synchronized (text) {
			System.out.println("text:" + text + ",thread:" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
