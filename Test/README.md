#  國泰 API Project #


## 環境準備 ##
1. 安裝 **JDK**，使用版本 8。
2. 安裝開發工具 intelliJ。

## swagger ##
http://localhost:8081/swagger-ui/index.html
沒有提供初始化資料，可透過swagger來完成CRUD的動作

## h2 ##
http://localhost:8081/h2

## 程式說明 ##
1. GetCoinDeskController：呼叫底下API，解析其下行內容並進行資料轉換。
- API 路徑：https://kengp3.github.io/blog/coindesk.json
2. CurrencyController：針對貨幣資料(CURRECNY資料表)進行CRUD等行為。
3. GetCoinDeskControllerTest
- 呼叫GetCoinDeskController的/api/v1/getCoinDesk，顯示其轉換後的內容。
4. CurrencyControllerTest
- tesAdd： 進行新增的測試，預期新增後的欄位值和當初新增時的欄位值皆相同，並顯示其內容。
- testQueryByCode： 進行查詢的測試(code=TWD)，預期取得的欄位值和當初新增時的欄位值皆相同，並顯示其內容。
- testQuery： 進行查詢的測試，預期查詢成功，預期查詢的結果不為null和empty，預期其中一筆資料的code為TWD。
- testUpdate： 進行更新的測試，預期查詢的結果不為null，預期其中一筆資料的name和當初更新時的欄位值相同，並顯示其內容。
- testDeleteCurrency： 進行刪除的測試(code=TWD)，預期成功執行且沒有回傳內容。