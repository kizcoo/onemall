package cn.iocoder.mall.systemservice.manager.errorcode;

import cn.iocoder.common.framework.vo.PageResult;
import cn.iocoder.mall.systemservice.convert.errorcode.ErrorCodeConvert;
import cn.iocoder.mall.systemservice.rpc.errorcode.dto.ErrorCodeAutoGenerateDTO;
import cn.iocoder.mall.systemservice.rpc.errorcode.dto.ErrorCodeCreateDTO;
import cn.iocoder.mall.systemservice.rpc.errorcode.dto.ErrorCodePageDTO;
import cn.iocoder.mall.systemservice.rpc.errorcode.dto.ErrorCodeUpdateDTO;
import cn.iocoder.mall.systemservice.rpc.errorcode.vo.ErrorCodeVO;
import cn.iocoder.mall.systemservice.service.errorcode.ErrorCodeService;
import cn.iocoder.mall.systemservice.service.errorcode.bo.ErrorCodeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* 错误码 Manager
*/
@Service
public class ErrorCodeManager {

    @Autowired
    private ErrorCodeService errorCodeService;

    /**
    * 创建错误码
    *
    * @param createDTO 创建错误码 DTO
    * @return 错误码
    */
    public Integer createErrorCode(ErrorCodeCreateDTO createDTO) {
        ErrorCodeBO errorCodeBO = errorCodeService.createErrorCode(ErrorCodeConvert.INSTANCE.convert(createDTO));
        return errorCodeBO.getId();
    }

    /**
    * 更新错误码
    *
    * @param updateDTO 更新错误码 DTO
    */
    public void updateErrorCode(ErrorCodeUpdateDTO updateDTO) {
        errorCodeService.updateErrorCode(ErrorCodeConvert.INSTANCE.convert(updateDTO));
    }

    /**
     * 自动生成错误码
     *
     * @param autoGenerateDTOs 自动生成信息 DTO
     */
    public void autoGenerateErrorCodes(List<ErrorCodeAutoGenerateDTO> autoGenerateDTOs) {
        errorCodeService.autoGenerateErrorCodes(ErrorCodeConvert.INSTANCE.convertList03(autoGenerateDTOs));
    }

    /**
    * 删除错误码
    *
    * @param errorCodeId 错误码编号
    */
    public void deleteErrorCode(Integer errorCodeId) {
        errorCodeService.deleteErrorCode(errorCodeId);
    }

    /**
    * 获得错误码
    *
    * @param errorCodeId 错误码编号
    * @return 错误码
    */
    public ErrorCodeVO getErrorCode(Integer errorCodeId) {
        ErrorCodeBO errorCodeBO = errorCodeService.getErrorCode(errorCodeId);
        return ErrorCodeConvert.INSTANCE.convert(errorCodeBO);
    }

    /**
    * 获得错误码列表
    *
    * @param errorCodeIds 错误码编号列表
    * @return 错误码列表
    */
    public List<ErrorCodeVO> listErrorCodes(List<Integer> errorCodeIds) {
        List<ErrorCodeBO> errorCodeBOs = errorCodeService.listErrorCodes(errorCodeIds);
        return ErrorCodeConvert.INSTANCE.convertList02(errorCodeBOs);
    }

    /**
    * 获得错误码分页
    *
    * @param pageDTO 错误码分页查询
    * @return 错误码分页结果
    */
    public PageResult<ErrorCodeVO> pageErrorCode(ErrorCodePageDTO pageDTO) {
        PageResult<ErrorCodeBO> pageResultBO = errorCodeService.pageErrorCode(ErrorCodeConvert.INSTANCE.convert(pageDTO));
        return ErrorCodeConvert.INSTANCE.convertPage(pageResultBO);
    }

    public List<ErrorCodeVO> listErrorCodes(String group, Date minUpdateTime) {
        List<ErrorCodeBO> errorCodeBOs = errorCodeService.listErrorCodes(group, minUpdateTime);
        return ErrorCodeConvert.INSTANCE.convertList02(errorCodeBOs);
    }

}