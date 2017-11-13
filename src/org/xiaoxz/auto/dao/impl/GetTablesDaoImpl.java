package org.xiaoxz.auto.dao.impl;


import org.xiaoxz.auto.bean.ColumnStruct;
import org.xiaoxz.auto.bean.TableStruct;
import org.xiaoxz.auto.dao.GetTablesDao;
import org.xiaoxz.auto.util.DataSourceUtil;
import org.xiaoxz.auto.util.NameUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : xiaoxz
 * @Date: Created in 2017/11/10
 * @Modified by :
 **/
public class GetTablesDaoImpl extends DataSourceUtil implements GetTablesDao {


    @Override
    public List<String> getTableNames() {
        List<String> tables = new ArrayList<>();
        String sql = "show tables";
        ResultSet rs = this.query(sql);
        try {
            while(rs.next()) {
                tables.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    @Override
    public List<TableStruct> getTableStruct() {
        List<String> tables = this.getTableNames();
        List<TableStruct> tableStruct = new ArrayList<>();
        String sql = null;
        for(int i=0; i<tables.size(); i++) {
            sql = "show columns from " + tables.get(i).toString();
            ResultSet rs = this.query(sql);
            try {
                List<ColumnStruct> list = new ArrayList<>();
                while(rs.next()) {
                    ColumnStruct cs = new ColumnStruct(rs.getString(1), rs.getString(2));
                    list.add(cs);
                }
                TableStruct tableStruct1 = new TableStruct(NameUtil.fileName(tables.get(i).toString()), list);
                tableStruct.add(tableStruct1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableStruct;
    }
}
