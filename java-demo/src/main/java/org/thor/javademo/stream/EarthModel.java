package org.thor.javademo.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2019-11-22 09:35
 * @Version: V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EarthModel {

    private TeaModel teaModel;

    private List<PersonModel> personModelList;
}
