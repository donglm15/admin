package com.unicom.admin.dao;

import com.unicom.admin.model.Market;
import com.unicom.admin.model.MarketExample.Criteria;
import com.unicom.admin.model.MarketExample.Criterion;
import com.unicom.admin.model.MarketExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MarketSqlProvider {

    public String deleteByExample(MarketExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("market");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Market record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("market");
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            sql.VALUES("startDate", "#{startDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndDate() != null) {
            sql.VALUES("endDate", "#{endDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEmployName() != null) {
            sql.VALUES("employName", "#{employName,jdbcType=VARCHAR}");
        }
        
        if (record.getImportance() != null) {
            sql.VALUES("importance", "#{importance,jdbcType=TINYINT}");
        }
        
        if (record.getJobPlace() != null) {
            sql.VALUES("jobPlace", "#{jobPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketTypeId() != null) {
            sql.VALUES("marketTypeId", "#{marketTypeId,jdbcType=TINYINT}");
        }
        
        if (record.getStatusId() != null) {
            sql.VALUES("statusId", "#{statusId,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MarketExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("startDate");
        sql.SELECT("endDate");
        sql.SELECT("employName");
        sql.SELECT("importance");
        sql.SELECT("jobPlace");
        sql.SELECT("content");
        sql.SELECT("marketTypeId");
        sql.SELECT("statusId");
        sql.FROM("market");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Market record = (Market) parameter.get("record");
        MarketExample example = (MarketExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("market");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=TINYINT}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            sql.SET("startDate = #{record.startDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("endDate = #{record.endDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEmployName() != null) {
            sql.SET("employName = #{record.employName,jdbcType=VARCHAR}");
        }
        
        if (record.getImportance() != null) {
            sql.SET("importance = #{record.importance,jdbcType=TINYINT}");
        }
        
        if (record.getJobPlace() != null) {
            sql.SET("jobPlace = #{record.jobPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketTypeId() != null) {
            sql.SET("marketTypeId = #{record.marketTypeId,jdbcType=TINYINT}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("statusId = #{record.statusId,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("market");
        
        sql.SET("id = #{record.id,jdbcType=TINYINT}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("startDate = #{record.startDate,jdbcType=TIMESTAMP}");
        sql.SET("endDate = #{record.endDate,jdbcType=TIMESTAMP}");
        sql.SET("employName = #{record.employName,jdbcType=VARCHAR}");
        sql.SET("importance = #{record.importance,jdbcType=TINYINT}");
        sql.SET("jobPlace = #{record.jobPlace,jdbcType=VARCHAR}");
        sql.SET("content = #{record.content,jdbcType=VARCHAR}");
        sql.SET("marketTypeId = #{record.marketTypeId,jdbcType=TINYINT}");
        sql.SET("statusId = #{record.statusId,jdbcType=TINYINT}");
        
        MarketExample example = (MarketExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Market record) {
        SQL sql = new SQL();
        sql.UPDATE("market");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getStartDate() != null) {
            sql.SET("startDate = #{startDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndDate() != null) {
            sql.SET("endDate = #{endDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEmployName() != null) {
            sql.SET("employName = #{employName,jdbcType=VARCHAR}");
        }
        
        if (record.getImportance() != null) {
            sql.SET("importance = #{importance,jdbcType=TINYINT}");
        }
        
        if (record.getJobPlace() != null) {
            sql.SET("jobPlace = #{jobPlace,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getMarketTypeId() != null) {
            sql.SET("marketTypeId = #{marketTypeId,jdbcType=TINYINT}");
        }
        
        if (record.getStatusId() != null) {
            sql.SET("statusId = #{statusId,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=TINYINT}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MarketExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}