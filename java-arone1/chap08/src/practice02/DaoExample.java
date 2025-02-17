package practice02;

public class DaoExample {
	static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) { 
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

	private static void dbWork(MySqlDao mySqlDao) {
		
	}

	private static void dbWork(OracleDao oracleDao) {
		
	}
}
