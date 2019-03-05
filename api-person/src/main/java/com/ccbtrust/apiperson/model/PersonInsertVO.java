package com.ccbtrust.apiperson.model;

import com.ccbtrust.remoteclient.enums.PersonCardType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * @author nzhang
 */
@Data
@ApiModel("添加员工时传入的数据")
public class PersonInsertVO {
    @ApiModelProperty(name = "personName",value = "员工姓名",required = true,example = "nn")
    @Pattern(regexp = "([\u4e00-\u9fa5]|[a-z]|[A-Z]){2,20}$",message = "名字应该由20个以内的汉字或英文字母组成")
    private String personName;

    @ApiModelProperty(name = "cardType",value = "证件类型",required = true, example = "IdCard")
    @NotNull(message = "证件类型不能为空")
    private PersonCardType cardType;

    @ApiModelProperty(name = "cardNum",value = "证件号码",required = true,example = "130823199001046101")
    @NotBlank(message = "证件号码不能为空")
    private String cardNum;
    @ApiModelProperty(name = "phoneNum",value = "电话号码",required = true,example = "13126572786")
    @Pattern(regexp = "^1[3-8][0-9]{9}$",message = "电话号码应该符合电话号码格式要求")
    private String phoneNum;
}
