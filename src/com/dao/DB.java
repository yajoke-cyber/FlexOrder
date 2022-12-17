package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB
{
	private Connection con;

	private PreparedStatement pstm;//PreparedStatement閿熸枻鎷烽敓鏂ゆ嫹pstm 

	private String user = "root";

	private String password = "123456";

	private String className = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://localhost:3306/db_dingcan";
	private String url = "jdbc:mysql://localhost:3306/db_dingcan?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
	public DB()
	{
		try
		{
			Class.forName(className);
		} catch (ClassNotFoundException e)
		{
			System.out.println("鍒涘缓鏁版嵁搴撳け璐�");
			e.printStackTrace();
		}
	}

	/** 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎹峰尅鎷烽敓鏂ゆ嫹閿熸枻鎷� */
	public Connection getCon()
	{
		try
		{
			con = DriverManager.getConnection(url, user, password);//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鎹峰尅鎷�
		} catch (SQLException e)
		{
			System.out.println("鑾峰彇杩炴帴閿欒");
			con = null;
			e.printStackTrace();
		}
		return con;
	}
//閿熸枻鎷烽敓鏂ゆ嫹閿熸嵎鍖℃嫹閿熸枻鎷峰垹閿熶茎鐨勮鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓璇紝閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
	public void doPstm(String sql, Object[] params)//params閿熻璇ф嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	{
		if (sql != null && !sql.equals(""))//瑕佹墽閿熷彨纰夋嫹sql閿熸枻鎷锋闯鏅冾亷鎷烽敓锟�
		{
			if (params == null)//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓杈冭鎷蜂负閿熸枻鎷�
				params = new Object[0];//閿熸枻鎷烽敓鏂ゆ嫹params

			getCon();//閿熸枻鎷烽敓鏂ゆ嫹getCon()閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰彇閿熸枻鎷烽敓鎹峰尅鎷烽敓鏂ゆ嫹閿熸枻鎷�
			if (con != null)
			{
				try
				{
					System.out.println(sql); //閿熸枻鎷烽敓绲奞L閿熸枻鎷烽敓锟�
					pstm = con.prepareStatement(sql,
							ResultSet.TYPE_SCROLL_INSENSITIVE,//閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鎬ㄩ敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鑾炶皨娲充紮鎷烽敓鏂ゆ嫹閿燂拷
							ResultSet.CONCUR_READ_ONLY);//閿熸枻鎷烽敓鏂ゆ嫹閿熻浼欐嫹閿燂拷
					for (int i = 0; i < params.length; i++)
					{
						pstm.setObject(i + 1, params[i]);
					}
					pstm.execute(); //閿熺煫纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
				} catch (SQLException e)
				{
					System.out.println("doPstm()閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹");
					e.printStackTrace();
				}
			}
		}
	}
//閿熸枻鎷峰彇閿熸枻鎷疯閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹瑁�
	public ResultSet getRs() throws SQLException
	{
		return pstm.getResultSet();
	}
//閿熸枻鎷峰彇閿熸枻鎷烽敓閾扮》鎷峰綍閿熶茎杈炬嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鐭ラ敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熷壙璁规嫹閿熷姭纭锋嫹褰�
	public int getCount() throws SQLException
	{
		return pstm.getUpdateCount();
	}
//閿熸埅鎲嬫嫹閿熸枻鎷烽敓鎹峰簱锛岄敓閰靛嚖鎷峰崰閿熺煫纰夋嫹閿熸枻鎷锋簮
	public void closed()
	{
		try
		{
			if (pstm != null)
				pstm.close();
		} catch (SQLException e)
		{
			System.out.println("閿熸埅鎲嬫嫹pstm閿熸枻鎷烽敓鏂ゆ嫹澶遍敓鏉帮綇鎷�");
			e.printStackTrace();
		}
		try
		{
			if (con != null)
			{
				con.close();
			}
		} catch (SQLException e)
		{
			System.out.println("閿熸埅鎲嬫嫹con閿熸枻鎷烽敓鏂ゆ嫹澶遍敓鏉帮綇鎷�");
			e.printStackTrace();
		}
	}
}
