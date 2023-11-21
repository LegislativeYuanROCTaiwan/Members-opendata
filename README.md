# 立法院開放資料服務平台
「當屆委員資料」、「當屆委員會-基本資料」、「各委員會-委員名單資料」、「歷屆委員資料」API技術說明文件
## 零、開放資料適用之授權條款
https://data.gov.tw/license
## 壹、程式說明
### 一、JAVA程式命名原則
1.	action
ID+ 流水號 + "Action"。
2.	Obj
ID+ 流水號 + "Obj"。
3.	ObjList
ID+ 流水號 + " ObjList"。
### 二、流水號編碼
當屆委員資料:9、當屆委員會-基本資料:13、各委員會-委員名單資料:14、歷屆委員資料:16。

## 貳、內容說明
### 一、當屆委員資料
#### （一）API程式代號：ID9Action
#### （二）資料集類別：委員類
#### （三）欄位名稱
1、term：屆別
2、name：委員姓名
3、ename：委員英文姓名
4、sex：性別
5、party：黨籍
6、partyGroup：黨團
7、areaName：選區名稱
8、committee：委員會
9、onboardDate：到職日(西元年)
10、degree：學歷
11、tel：電話
12、experience：經歷
13、fax：傳真
14、addr：通訊處
15、picUrl：照片位址
16、leaveFlag：是否離職
17、leaveDate：離職日期(西元年)
18、leaveReason：離職原因
#### （四）詮釋資料說明：https://data.ly.gov.tw/getds.action?id=9
#### （五）API參數
1、name：委員姓名
2、sex：性別
3、party：黨籍
4、partyGroup：黨團
5、areaName：選區名稱
6、committee：委員會
7、fileType：檔案類型，可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID9Action.action?name=孔文吉&sex=男&party=中國國民黨&partyGroup=中國國民黨&areaName=山地原住民選舉區&committee=&fileType=csv

### 二、當屆委員會-基本資料
#### （一）API程式代號：ID13Action
#### （二）資料集類別：委員類
#### （三）欄位名稱：
1、comtcd：委員會代號
2、comtName：委員會名稱
3、comtDesp：委員會/職掌
4、comtType：委員會類別(1:常設委員會、2:特種委員會、3:國會改革前舊委員會名稱)。
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=13
#### （五）API參數
1、comtName：委員會名稱
2、comtType：委員會類別
3、fileType：檔案類型，可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID13Action.action?comtName=內政委員會&comtType=1&fileType=csv

### 三、各委員會-委員名單資料
#### （一）API程式代號：ID14Action
#### （二）資料集類別：委員類
#### （三）欄位名稱：
1、committee：委員會名稱
2、lgno：委員編號
3、name：委員名稱
4、term：屆別
5、sessionPeriod：會期
6、isCoChairman：是否為召集委員
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=14
#### （五）API參數
1、committee：委員會名稱
2、name：委員名稱
3、fileType：檔案類型，可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID14Action.action?committee=內政委員會&name=&fileType=csv

### 四、歷屆委員資料
#### （一）API程式代號：ID16Action
#### （二）資料集類別：委員類
#### （三）欄位名稱：
1、term：屆別
2、name：委員姓名
3、ename：委員英文姓名
4、sex：性別
5、party：黨籍
6、partyGroup：黨團
7、areaName：選區名稱
8、committee：委員會
9、onboardDate：到職日(西元年)
10、degree：學歷
11、experience：經歷
12、picPath：照片位址
13、leaveFlag：是否離職
14、leaveDate：離職日期(西元年)
15、leaveReason：離職原因
#### （四）詮釋資料：https://data.ly.gov.tw/getds.action?id=16
#### （五）API參數
1、term：屆別
2、name：委員姓名
3、sex：性別
4、party：黨籍
5、partyGroup：黨團
6、areaName：選區名稱
7、fileType：檔案類型，可為json、xml、csv、txt、xls。
#### （六）API範例：https://data.ly.gov.tw/odw/ID16Action.action?name=&sex=女&party=&partyGroup=&areaName=&term=10&fileType=csv
