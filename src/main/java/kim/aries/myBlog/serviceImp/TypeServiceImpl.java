package kim.aries.myBlog.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kim.aries.myBlog.dao.TypeDao;
import kim.aries.myBlog.domain.Type;
import kim.aries.myBlog.service.TypeService;

@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Autowired
	private TypeDao typeDao;

	@Override
	public int addType(Type type) {
		// TODO Auto-generated method stub
		return this.typeDao.addType(type);
	}

	@Override
	public int delTypeById(int typeId) {
		// TODO Auto-generated method stub
		return this.typeDao.delTypeById(typeId);
	}

	@Override
	public List<Type> getAllType() {
		// TODO Auto-generated method stub
		List<Type> typeList=this.typeDao.getAllType();
		for(Type type:typeList){
			type.setCount(this.typeDao.countBlog(type.getId()));
		}
		return typeList;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public List<Type> getShowType() {
		// TODO Auto-generated method stub
		List<Type> typeList=this.typeDao.getShowType();
		for(Type type:typeList){
			type.setCount(this.typeDao.countBlog(type.getId()));
		}
		return typeList;
	}

	@Override
	public int editType(Type type) {
		// TODO Auto-generated method stub
		return this.typeDao.editType(type);
	}

	@Override
	public Type findTypeById(int id) {
		// TODO Auto-generated method stub
		return this.typeDao.findTypeById(id);
	}

}
