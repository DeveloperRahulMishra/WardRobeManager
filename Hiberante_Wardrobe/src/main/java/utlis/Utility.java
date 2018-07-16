/**
 * 
 */
package utlis;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

/**
 * @author Rahul
 *
 */
public class Utility {

	/**
	 * nullcheck
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj) {

		if (obj instanceof String) {
			String value = (String) obj;
			return (value != null && !value.isEmpty()) ? true : false;
		} else if (obj instanceof Collection) {
			Collection value = (Collection) obj;
			return (value != null && !value.isEmpty()) ? true : false;
		} else if (obj instanceof Map) {
			Map value = (Map) obj;
			return (value != null && !value.isEmpty()) ? true : false;
		} else if (obj instanceof Object) {
			return (obj != null) ? true : false;
		}
		return false;
	}

	/**
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public static void close(Object obj) throws SQLException {
		new Utility().closing(obj);
	}

	/**
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public static void close(Object... obj) throws SQLException {

		for (int i = 0; i <= obj.length - 1; i++) {

			new Utility().closing(obj[i]);
		}
	}

	/**
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void closing(Object obj) throws SQLException {

		if (Utility.isNotNull(obj)) {
			if (obj instanceof Connection) {
				((Connection) obj).close();
			} else if (obj instanceof ResultSet) {
				((ResultSet) obj).close();
			} else if (obj instanceof Statement) {
				((Statement) obj).close();
			} else if (obj instanceof AutoCloseable) {
				try {
					((AutoCloseable) obj).close();
				} catch (Exception e) {
					throw new SQLException(e.getMessage());
				}
			} else if (obj instanceof Closeable) {
				try {
					((Closeable) obj).close();
				} catch (Exception e) {
					throw new SQLException(e.getMessage());
				}
			}
		}
	}
}
