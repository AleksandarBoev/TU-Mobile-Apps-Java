package tu.practise.firm.services;

import java.util.List;

import tu.practise.firm.database.FirmDatabase;
import tu.practise.firm.database.daos.DepartmentDao;
import tu.practise.firm.database.entities.Department;
import tu.practise.firm.domain.models.binding.DepartmentBindingModel;
import tu.practise.firm.domain.models.view.DepartmentViewModel;
import tu.practise.firm.utils.CustomModelMapper;

public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<DepartmentViewModel> getAll() {
        return departmentDao.getAllDepartmentViews();
    }

    @Override
    public DepartmentViewModel getById(Integer departmentId) {
        return departmentDao.getDepartmentViewById(departmentId);
    }

    @Override
    public void save(DepartmentBindingModel departmentBindingModel) {
        //TODO verify departmentBindingModel field values
        Department department = new Department();
        CustomModelMapper.map(departmentBindingModel, department);

        departmentDao.saveDepartment(department);
    }
}
