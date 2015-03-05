package dwz.business.goods.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.SessionOper;
import dwz.business.goods.AddStandard;
import dwz.business.goods.ProductStandardServiceMgr;
import dwz.business.goods.SearchStandardVO;
import dwz.business.goods.Standard;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.beans.ProStandard;
import dwz.persistence.mapper.StandardMapper;

@Transactional(rollbackFor = Exception.class)
@Service("productStandardServiceMgr")
public class ProductStandardServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ProductStandardServiceMgr {
	
	@Autowired
	private StandardMapper standardMapper;
	
	@Override
	public int searchProductStandardCount(SearchStandardVO vo,
			SessionOper sessionOper) {
		vo.setOrgId(sessionOper.getOrgId());
		return standardMapper.findCountByQC(vo);
	}

	@Override
	public List<Standard> searchProductStandard(SearchStandardVO vo,
			SessionOper sessionOper) {
		List<Standard> bos = new ArrayList<Standard>();
		vo.setOrgId(sessionOper.getOrgId());
		List<ProStandard> pos = standardMapper.findByQC(vo);
		for (ProStandard po : pos) {
			bos.add(new Standard(po));
		}
		return bos;
	}

	@Override
	public List<Integer> checkStandard(AddStandard addStandard) {
		
		List<Integer> rowNoList = new ArrayList<Integer>();
		
		int i = 0;
		
		for(Standard standard : addStandard.getStandardList()){
			if(standard.getProductId() == null) continue;
			
			Map<Object, Object> paramMap = new HashMap<Object, Object>();
			paramMap.put("productId", standard.getProductId());
			paramMap.put("standard", standard.getStandard());
			
			ProStandard po = standardMapper.getStandardForCheck(paramMap);
			if(po != null){
				rowNoList.add(i);
			}
			
			i++;
		}
		
		return rowNoList;
	}

	@Override
	public void addStandard(AddStandard addStandard) {
		
		for(Standard standard : addStandard.getStandardList()){
			if(standard.getProductId() == null) continue;
			standardMapper.insert(standard.getProStandard());
		}
		
	}

	@Override
	public void del(int standardId) {
		standardMapper.delete(standardId);
	}

}
