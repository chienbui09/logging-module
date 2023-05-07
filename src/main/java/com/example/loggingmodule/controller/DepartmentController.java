package com.example.loggingmodule.controller;

import com.example.loggingmodule.dto.DepartmentDto;
import com.example.loggingmodule.entity.Department;
import com.example.loggingmodule.forms.DepartmentCreateForm;
import com.example.loggingmodule.forms.DepartmentFilterForm;
import com.example.loggingmodule.forms.DepartmentUpdateForm;
import com.example.loggingmodule.service.IDepartmentService;
import com.example.loggingmodule.validation.DepartmentIdExisted;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/departments")
@AllArgsConstructor
public class DepartmentController {

    private final IDepartmentService service;

    private final ModelMapper mapper;

    @GetMapping()
    public Page<DepartmentDto> findAll(
        @SortDefault(value = "totalMembers", direction = Sort.Direction.DESC) Pageable pageable,
        DepartmentFilterForm form
    ){
        Page<Department> page = service.findAll(pageable, form);
        return page.map( department -> {
            DepartmentDto dto = mapper.map(department, DepartmentDto.class);
            dto.add(
                    linkTo(
                            methodOn(DepartmentController.class).findById(department.getId())
                    ).withSelfRel()
            );
            return dto;
        });
    }

    @GetMapping("/{id}")
    public DepartmentDto findById(@PathVariable("id") @DepartmentIdExisted int id){
        Department department = service.findById(id);
        DepartmentDto dto = mapper.map(department, DepartmentDto.class);
        dto.add(
                linkTo(methodOn(DepartmentController.class).findById(id)
                ).withSelfRel()
        );
        return dto;
    }

    @PostMapping
    public void create(@RequestBody @Valid DepartmentCreateForm form){
        service.create(form);
    }

    @PutMapping
    public void update(@RequestBody @Valid DepartmentUpdateForm form){
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllByIds(@RequestBody List<Integer> ids){
        service.deleteAllById(ids);
    }
}
// @Valid: Dùng khi truyền vào 1 class (nhiều trường)
// @Anotaion: Dùng khi truyền vào 1 trường
// MethodArgumentInvalid: exception khi xảy ra lỗi ở body truyền vào
// ConstraintViolation: lỗi ở @Pathvariable: biến truyền vào đường dẫn
