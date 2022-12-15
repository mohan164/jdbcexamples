package jdbcexample;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

interface abc{
	public void abc();
	public void ddd();
	
}
 class a implements abc{
	@Override
	public void abc() {
		// TODO Auto-generated method stub
		System.out.println("abc method called of a class");
		
	}

	@Override
	public void ddd() {
		// TODO Auto-generated method stub
		System.out.println("inside ddd method of a class");
	}
	
	
}
 class b implements abc{

		@Override
		public void abc() {
			// TODO Auto-generated method stub
			System.out.println("abc method called of b class");
			
		}

		@Override
		public void ddd() {
			// TODO Auto-generated method stub
			System.out.println("inside ddd method of b class");
		}
		
		
	}
public class interfaceexample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		abc a=new a();
		a.abc();
		
		b abc=new b();
		

	}

}
