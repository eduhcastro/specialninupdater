/*
 * Copyright 2021 Matias.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author Matias
 */
public class ConfigModel {

    private StringBuilder model(int version) {
        StringBuilder Model = new StringBuilder("UPDATE_TRY_VERSION_MAX = "+version+"\n"
                + "UPDATE_VERSION_MAX = "+version+"\n"
                + "\n"
                + "VerPath = {\n"
                + "}\n"
                + "VerMergePath = {\n"
                + "}\n"
                + "\n"
                + "CDN_URL = \"http://192.168.1.100:86\"\n"
                + "CDN_URL2 = \"http://192.168.1.100:86/\"\n"
                + "CDN_RES_URL = CDN_URL .. \"/update/update_allres\"\n"
                + "CDN_RES_GY_URL = CDN_URL .. \"/update/update_allres\"\n"
                + "REG_URL = \"http://regset-sszg.hoachi2.mobi\" \n"
                + "DOWN_APK_URL = \"http://oss.api.hoachi2.mobi/index.php/ChannelBag/bag\"\n"
                + "ZIP_URL = \"http://regset-sszg.hoachi2.mobi/update/config/sszg/update/\"\n"
                + "NEED_CHECK_CLOSE=true \n"
                + "RESOURCES_DOWNLOAD_PRO      = 3           \n"
                + "RESOURCES_DOWNLOAD_PRO_MAX  = 5\n"
                + "VER_UPDATE_ERR_MAX  = 2000\n"
                + "\n"
                + "\n"
                + "\n"
                + "function webFunc_urlConfigEnd()\n"
                + "end\n"
                + "\n"
                + "\n"
                + "function webFunc_initInstanceStart()\n"
                + "end\n"
                + "\n"
                + "\n"
                + "function webFunc_initInstanceEnd()\n"
                + "end\n"
                + "\n"
                + "function webFunc_GameStart()\n"
                + "end\n"
                + "\n"
                + "\n"
                + "CDN_PATH_BASE = CDN_URL..\"/update/update_all/\"\n"
                + "UPDATE_MODE_BY_INC = true\n"
                + "INC_VER_DOWNLOAD_PRO_MAX = 8\n"
                + "PLATFORM_NAME               = \"symlf\"\n"
                + "FINAL_CHANNEL               = \"symlf\"\n"
                + "\n"
                + "\n"
                + "SHOW_BAIDU_TIEBA            = false              \n"
                + "SHOW_SINGLE_INVICODE        = true                \n"
                + "SHOW_BIND_PHONE             = false              \n"
                + "SHOW_WECHAT_CERTIFY         = false              \n"
                + "SHOW_GAME_SHARE             = true              \n"
                + "SHOW_GM                     = true\n"
                + "AUTO_SHOW_NOTICE            = false\n"
                + "SHOW_NOTICE                 = false\n"
                + "DEBUG_MODE                  = true\n"
                + "\n"
                + "URL_PATH_ALL = {}\n"
                + "URL_PATH_ALL.other = {\n"
                + "    update = CDN_URL2..\"/update/update_android_sszg_apk\",\n"
                + "    register = CDN_URL\n"
                + "	\n"
                + "}\n"
                + "URL_PATH_ALL.get = function(platform)\n"
                + "    local data = URL_PATH_ALL[platform] or URL_PATH_ALL[\"other\"]\n"
                + "    return data\n"
                + "end\n"
                + "\n"
                + "function get_servers_url(account, platform, channelid, srvid, start, num)\n"
                + "	\n"
                + "function sdkOnPay(money, buyNum, prodId, productName, productDesc)\n"
                + "    if 1 > 2 then \n"
                + "	   callFunc(\"touristMode\", \"10\")\n"
                + "    else\n"
                + "        local loginData = LoginController:getInstance():getModel():getLoginData()\n"
                + "        local roleVo = RoleController:getInstance():getRoleVo()\n"
                + "        if not roleVo then return end\n"
                + "\n"
                + "		local productId = string.format(\"%s\",  prodId)\n"
                + "        if PAY_ID_FUNC then\n"
                + "            productId = PAY_ID_FUNC(prodId, money)\n"
                + "        elseif PAY_ID_NORMAL then\n"
                + "            productId = prodId\n"
                + "        end\n"
                + "        local config = Config.ChargeData.data_charge_data[prodId]\n"
                + "        if config and config.val ~= money then return end\n"
                + "        productName = productName or (money * 10)..TI18N(\"钻石\")\n"
                + "        productDesc = productDesc or productName\n"
                + "        local price = money\n"
                + "        if USE_RMB_FEN then\n"
                + "            price = money * 100\n"
                + "        end\n"
                + "        buyNum = buyNum or 1\n"
                + "        local srvData = loginData\n"
                + "        local channel = LoginPlatForm:getInstance():getChannel()\n"
                + "        local gold = roleVo.gold\n"
                + "        local platform, serverId = unpack(Split(roleVo.srv_id, \"_\"))\n"
                + "        local serverName = srvData.srv_name\n"
                + "        local roleId = roleVo.rid\n"
                + "        local srv_id = roleVo.srv_id		\n"
                + "        local roleName = roleVo.name\n"
                + "        local roleLev = roleVo.lev\n"
                + "        local vip = \"vip\"..roleVo.vip_lev\n"
                + "        local ext = roleVo.rid..\"$$\"..platform..\"$$\"..serverId..\"$$\"..channel..\"$$\"..prodId..\"$$\"..productName\n"
                + "		local host = srvData.host\n"
                + "        local account_id = account\n"
                + "		\n"
                + "        local info = table.concat({productId, productName, productDesc, price, buyNum, gold, serverId, serverName, roleId, roleName, roleLev, vip, ext, host, channel, account_id}, \"#\")\n"
                + "\n"
                + "        if (1 > 2) then\n"
                + "            local str = string.format( TI18N(\"Bạn có chắc chắn nạp tiền??\"),  roleName)\n"
                + "            CommonAlert.show( str, TI18N(\"Xác nhận\"), function()\n"
                + "            iceBirdOnPay(productId, productName, productDesc, price, buyNum, gold, serverId, serverName, roleId, roleName, roleLev, vip, ext, host,srv_id,money,account_id)\n"
                + "            end, TI18N(\"Hủy\"))\n"
                + "        else\n"
                + "            if (false) then\n"
                + "			   \n"
                + "			    local str = string.format( TI18N(\"Bạn có chắc chắn nạp tiền??\"),  roleName)\n"
                + "		        CommonAlert.show( str, TI18N(\"Xác nhận\"), function()\n"
                + "			    iceBirdOnPay(productId, productName, productDesc, price, buyNum, gold, serverId, serverName, roleId, roleName, roleLev, vip, ext, host,srv_id,money,account_id)\n"
                + "    	        end, TI18N(\"Hủy\"))\n"
                + "            else\n"
                + "			   \n"
                + "                if IS_SY_DAN then\n"
                + "					\n"
                + "					local str = string.format( TI18N(\"Bạn có chắc chắn nạp tiền??\"),  roleName)\n"
                + "					CommonAlert.show( str, TI18N(\"Xác nhận\"), function()\n"
                + "					iceBirdOnPay(productId, productName, productDesc, price, buyNum, gold, serverId, serverName, roleId, roleName, roleLev, vip, ext, host,srv_id,money,account_id)\n"
                + "					end, TI18N(\"Hủy\"))\n"
                + "                else\n"
                + "				\n"
                + "					local str = string.format( TI18N(\"Bạn có chắc chắn nạp tiền??\"),  roleName)\n"
                + "					CommonAlert.show( str, TI18N(\"Xác nhận\"), function()\n"
                + "					iceBirdOnPay(productId, productName, productDesc, price, buyNum, gold, serverId, serverName, roleId, roleName, roleLev, vip, ext, host,srv_id,money,account_id)\n"
                + "					end, TI18N(\"Hủy\"))\n"
                + "                end\n"
                + "            end\n"
                + "        end\n"
                + "    end\n"
                + "end\n"
                + "    return string.format(\"%s/api/role.php?account=%s&platform=%s&chanleId=%s&srvid=%s\", URL_PATH.register, account, platform, DEF_CHANNEL or 'dev', srvid)\n"
                + "end\n"
                + "\n"
                + "function get_notice_url(days, loginData)\n"
                + "	local host = REAL_LOGIN_DATA and REAL_LOGIN_DATA.host or loginData.host\n"
                + "    return string.format(\"http://192.168.1.100:81/gonggao.php\", host, os.time())\n"
                + "end\n"
                + "\n"
                + "require(\"cli_log\")");

        return Model;

    }

    public void Handler(int version, String path) throws IOException {
        //CreateFile(path);
        StringBuilder modelo = model(version);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/future_config.lua"))) {
            writer.write(modelo.toString());
         } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error to create file config!");
            System.out.println("An error occurred.");
        }
    }
}
