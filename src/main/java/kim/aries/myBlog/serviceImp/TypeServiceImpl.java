package kim.aries.myBlog.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return this.typeDao.getAllType();
	}

	@Override
	public List<Type> getShowType() {
		// TODO Auto-generated method stub
		return this.typeDao.getShowType();
	}

	@Override
	public int editType(Type type) {
		// TODO Auto-generated method stub
		return this.typeDao.editType(type);
	}

}
