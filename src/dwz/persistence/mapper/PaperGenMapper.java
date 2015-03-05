package dwz.persistence.mapper;

import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysPaperGen;

@Repository
public interface PaperGenMapper extends BaseMapper<SysPaperGen, Integer> {
	
	SysPaperGen getOne(SysPaperGen sysPaperGen);
	
}
