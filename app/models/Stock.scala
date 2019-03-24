package models

case class Stock(symbol: String, price: Double)

object Stock {

  import play.api.libs.json._

  implicit object StockFormat extends Format[Stock] {
    // convert from JSON string to scala object: deserialize from JSON
    def reads(json: JsValue): JsResult[Stock] = {
      val symbol = (json \ "symbol").as[String]
      val price = (json \ "price").as[Double]
      JsSuccess(Stock(symbol, price))
    }

    // convert from Stock Object to JSON: serialize to JSON
    def writes(s: Stock): JsValue = {
      val stockList = Seq("symbol" -> JsString(s.symbol), "price" -> JsNumber(s.price))
      // JsObject requires Seq[String, JsValue]
      JsObject(stockList)
    }

  }

}