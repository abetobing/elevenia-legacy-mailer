package id.co.elevenia.legacy.mailer.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.Instant;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.EnhancedUserType;

import oracle.sql.DATE;

public class OracleDate implements EnhancedUserType,Serializable {

	private static final int[] SQL_TYPES = new int[] {
	        Types.TIMESTAMP
	    };
	
	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return SQL_TYPES;
	}

	@Override
	public Class returnedClass() {
		return Instant.class;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        Instant dtx = (Instant) x;
        Instant dty = (Instant) y;
        return dtx.equals(dty);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner)
			throws HibernateException, SQLException {
		Object timestamp = StandardBasicTypes.TIMESTAMP.nullSafeGet(rs, names, session, owner);
        if (timestamp == null) {
            return null;
        }
        Date ts = (Date) timestamp;
        Instant instant = Instant.ofEpochMilli(ts.getTime());
        return instant;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		 if (value == null) {
	            StandardBasicTypes.TIMESTAMP.nullSafeSet(st, null, index, session);
	        } else {
	            Instant ldt = ((Instant) value);
	            st.setObject(index, new DATE(Timestamp.from(ldt)));
	        }
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		// TODO Auto-generated method stub
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		// TODO Auto-generated method stub
		return original;
	}

	@Override
	public String objectToSQLString(Object value) {
        throw new UnsupportedOperationException();
	}

	@Override
	public String toXMLString(Object value) {
		// TODO Auto-generated method stub
		return value.toString();
	}

	@Override
	public Object fromXMLString(String xmlValue) {
		return Instant.parse(xmlValue);
	}

}
