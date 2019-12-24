package Service;

import Dao.PartnerCompanyDao;

public class PartnerCompanyManagementServiceImpl implements PartnerCompanyManagementService {
    public PartnerCompanyDao partnerCompanyDao = new PartnerCompanyDao();
    @Override
    public void addPartnerCompany() {
        partnerCompanyDao.addPartnerCompany();
    }

    @Override
    public void deletePartnerCompany() {
        partnerCompanyDao.deletePaterCompany();
    }
}
