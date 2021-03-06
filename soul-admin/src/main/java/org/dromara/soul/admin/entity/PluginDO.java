/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.dromara.soul.admin.entity;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.dromara.soul.admin.dto.PluginDTO;
import org.dromara.soul.common.enums.PluginEnum;
import org.dromara.soul.common.utils.UUIDUtils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * PluginDO.
 *
 * @author jiangxiaofeng(Nicholas)
 */
@Data
public class PluginDO extends BaseDO {

    /**
     * plugin name.
     */
    private String name;

    /**
     * whether enabled.
     */
    private Boolean enabled;

    /**
     * build pluginDO.
     *
     * @param pluginDTO {@linkplain PluginDTO}
     * @return {@linkplain PluginDO}
     */
    public static PluginDO buildPluginDO(final PluginDTO pluginDTO) {
        if (pluginDTO != null) {
            PluginDO pluginDO = new PluginDO();
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            if (StringUtils.isEmpty(pluginDTO.getId())) {
                pluginDO.setId(UUIDUtils.generateShortUuid());
                pluginDO.setDateCreated(currentTime);
            } else {
                pluginDO.setId(pluginDTO.getId());
            }
            pluginDO.setName(PluginEnum.getPluginEnumByCode(pluginDTO.getCode()).getName());
            pluginDO.setEnabled(pluginDTO.getEnabled());
            pluginDO.setDateUpdated(currentTime);
            return pluginDO;
        }
        return null;
    }
}
