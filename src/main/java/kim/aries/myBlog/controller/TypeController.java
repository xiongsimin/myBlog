package kim.aries.myBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.aries.myBlog.domain.Result;
import kim.aries.myBlog.domain.Type;
import kim.aries.myBlog.service.TypeService;
@CrossOrigin
@RestController
public class TypeController {
	@Autowired
	private TypeService typeService;

	@PostMapping("/addType")
	Result addType(@RequestBody Type type, Result result) {
		if (this.typeService.addType(type) == 1) {
			result.setSuccess(true);
			result.setMsg("添加成功！");
		} else {
			result.setSuccess(true);
			result.setMsg("添加失败！");
		}
		return result;
	}

	@GetMapping("/delType")
	Result delType(int typeId, Result result) {
		if (this.typeService.delTypeById(typeId) == 1) {
			result.setSuccess(true);
			result.setMsg("删除成功！");
		} else {
			result.setSuccess(false);
			result.setMsg("删除失败！");
		}
		return result;
	}

	@GetMapping("/getAllType")
	Result getAllType(Result result) {
		List<Type> typeList = this.typeService.getAllType();
		result.setSuccess(true);
		result.setData(typeList);
		return result;
	}

	@GetMapping("/getShowType")
	Result getShowType(Result result) {
		List<Type> typeList = this.typeService.getShowType();
		result.setSuccess(true);
		result.setData(typeList);
		return result;
	}

	@PostMapping("/editType")
	Result editType(Type type, Result result) {
		if (this.typeService.editType(type) == 1) {
			result.setSuccess(true);
			result.setMsg("修改成功！");
		} else {
			result.setSuccess(true);
			result.setMsg("修改失败！");
		}
		return result;

	}
	@GetMapping("/findTypeById")
	Result findTypeById(int id, Result result){
		Type type=this.typeService.findTypeById(id);
		result.setSuccess(true);
		result.setData(type);
		return result;
	}
}
