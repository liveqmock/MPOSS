package dwz.persistence.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import dwz.business.system.SearchLogVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysLog;

@Repository
public interface LogMapper extends BaseMapper<SysLog, Integer> {
	
	int findCountByQC(SearchLogVO vo);
	
	List<SysLog> findByQC(SearchLogVO vo);
	
}
