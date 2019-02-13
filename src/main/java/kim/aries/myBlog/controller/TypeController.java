package kim.aries.myBlog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kim.aries.myBlog.domain.Type;
import kim.aries.myBlog.service.TypeService;

@RestController
public class TypeController {
	@Autowired
	private TypeService typeService;

	@PostMapping("/addType")
	String addType(@RequestBody Type type) {
		if (this.typeService.addType(type) == 1) {
			return "添加成功!";
		} else {
			return "添加失败！";
		}
	}

	@GetMapping("/delType")
	String delType(int typeId) {
		if (this.typeService.delTypeById(typeId) == 1) {
			return "删除成功！";
		} else {
			return "删除失败！";
		}
	}

	@GetMapping("/getAllType")
	List<Type> getAllType() {
		return this.typeService.getAllType();
	}

	@GetMapping("/getShowType")
	List<Type> getShowType() {
		return this.typeService.getShowType();
	}

	@PostMapping("/editType")
	String editType(Type type) {
		if (this.typeService.editType(type) == 1) {
			return "修改成功！";
		} else {
			return "修改失败！";
		}

	}
}
