import React, {Component, useEffect, useState} from "react";
import {Chart} from "react-google-charts";
import logo from './logo.png';
import "./App.css";
import moreinfo from "./menu-symbol-of-three-parallel-lines-svgrepo-com.svg"
import tradesense from './tradesense-logo.png'

function Watchlist(props){

  const data = props.data
  const updateCashComponent = props.updateCash;

  const handleBuy = (ticker) => {
    //handle buy action
    const stockToBuy = data.find((stock) => stock['ticker'] == ticker);
    const buyCost = stockToBuy['price'];
    updateCashComponent(-buyCost);
    fetch(`http://localhost:8080/api/stock/${ticker}/buyStock/1`, {method: 'PUT'})
    .then(console.log(`Bought stock ${ticker}`))
    .then(console.log(`price of ${buyCost}`))
    .catch(err => console.error(err));
  }
  const handleSell = (ticker) => {
    //handle sell action
    const stockToSell = data.find((stock) => stock['ticker'] == ticker);
    const sellCost = stockToSell['price'];
    updateCashComponent(sellCost);
    fetch(`http://localhost:8080/api/stock/${ticker}/sellStock/1`, {method: 'PUT'})
    .then(console.log(`Sold stock ${ticker}`))
    .catch(err => console.error(err));
  }

  return(
      <div className="watchlist-container" style={{backgroundColor:(data.length%2==0)?"#E5e4e2":"#f9f8f8"}}>
        <div className="watchlist-header">
          <div className="watchlist-header-element watchlist-header-element-normal">Ticker</div>
          <div className="watchlist-header-element watchlist-header-element-name">Name</div>
          <div className="watchlist-header-element watchlist-header-element-normal">Price</div>
          <div className="watchlist-header-element watchlist-header-element-normal">Change</div>
          <div className="watchlist-header-element watchlist-header-element-normal">Shares</div>
          <div className="watchlist-header-element watchlist-header-element-actions">Actions</div>
        </div>
        {
          data.map((stock, index) =>{ 
            return (
            <div key={index} className = {(index%2==0?"odd-box":"even-box")}>
              <div key={index+"ticker"} className = {(index%2==0?"odd-box-element":"even-box-element")}>{stock["ticker"]}</div>
              <div key={index+"companyName"} className = {(index%2==0?"odd-box-element-name":"even-box-element-name")}>{stock["companyName"]}</div>
              <div key={index+"price"} className = {(index%2==0?"odd-box-element":"even-box-element")}>{(Math.round(stock["price"]*100)/100)}</div>
              <div key={index+"change"} className = {[(index%2==0?"odd-box-element":"even-box-element"),((stock["dailyChange"]<0)?"redText":"greenText")].join(" ")}>{(Math.round(stock["dailyChange"]*10000)/100)}</div>
              <div key={index+"quantity"} className = {(index%2==0?"odd-box-element":"even-box-element")}>{stock["quantity"]}</div> 
              <div style={{width:"120px", margin:0,padding:0,display:"inline-block",backgroundColor:(index%2==0?"#E5e4e2":"#f9f8f8"), paddingTop:"2px"}}>
                <button onClick={() => handleBuy(stock['ticker'])} className="button button1">Buy</button>
                <button onClick={() => handleSell(stock['ticker'])}className="button button3">Sell</button>
              </div>
            </div>)
          } )
        }
      </div>
  )
}

function Summary_component(props){
  const value = props.value
  const title = props.title

  return(
      <div className="summary_component">
        <div className="summary_component_title"><u>{title}</u></div>
        <b className="summary_component_value">{value}</b>    
      </div>
  )
}


function App() {
  const [data,setData] = useState([])
  const [performanceData, setPerformanceData] = useState([["time", "value"]])
  const [time, setTime] = useState(Date.now());

  useEffect(() => {
    const interval = setInterval(() => {
      fetch('http://localhost:8080/api/stock/', {method: 'GET'})
        .then(response => response.json())
        .then(response => setData(response))
        .catch(err => console.error(err));
    }, 3000);
    return () => {
      clearInterval(interval);
    };
  }, []);

  useEffect(()=>{
    if(performanceData.length==31){
      performanceData.splice(1,1)
      for(let i=1; i<30; i++){
        performanceData[i][0]-=1
      }
    }
    performanceData.push([performanceData.length,myBalance])
  },[data])


  const options = {
    pieHole: 0.5,
    is3D: false,
    backgroundColor: "#f8f6f7",
    chartArea: {width: "90%", height: "90%"},
    legend: {position:"none"}
  };
  
  const line_chart_options = {
    curveType: "function",
    backgroundColor: "#f8f6f7",
    chartArea: {width: "85%", height: "90%"},
    vAxis: {scaleType:"discrete"},
    hAxis: {textPosition: "none"},
    legend: {position:"none"}
  };
  //const data = [{"ticker":"AAPL","companyName":"Apple Inc.","price":150.5,"dailyChange":-0.33,"quantity":100.0,"sector":"Technology"},{"ticker":"GOOGL","companyName":"Alphabet Inc.","price":2800.2,"dailyChange":0.18,"quantity":50.0,"sector":"Technology"},{"ticker":"AMZN","companyName":"Amazon.com Inc.","price":3250.75,"dailyChange":-0.48,"quantity":75.0,"sector":"Technology"},{"ticker":"MSFT","companyName":"Microsoft Corporation","price":290.4,"dailyChange":-0.21,"quantity":120.0,"sector":"Technology"},{"ticker":"TSLA","companyName":"Tesla","price":700.0,"dailyChange":0.38,"quantity":30.0,"sector":"Automotive"},{"ticker":"JPM","companyName":"JPMorgan Chase & Co.","price":150.8,"dailyChange":0.17,"quantity":90.0,"sector":"Finance"},{"ticker":"NVDA","companyName":"NVIDIA Corporation","price":220.3,"dailyChange":-0.1,"quantity":65.0,"sector":"Technology"},{"ticker":"WMT","companyName":"Walmart Inc.","price":140.1,"dailyChange":0.32,"quantity":110.0,"sector":"Retail"},{"ticker":"JNJ","companyName":"Johnson & Johnson","price":170.25,"dailyChange":0.43,"quantity":85.0,"sector":"Healthcare"},{"ticker":"BAC","companyName":"Bank of America Corporation","price":40.5,"dailyChange":-0.16,"quantity":150.0,"sector":"Finance"},{"ticker":"XOM","companyName":"Exxon Mobil Corporation","price":60.7,"dailyChange":0.07,"quantity":70.0,"sector":"Energy"},{"ticker":"PFE","companyName":"Pfizer Inc.","price":45.8,"dailyChange":0.21,"quantity":200.0,"sector":"Healthcare"},{"ticker":"HD","companyName":"The Home Depot","price":350.9,"dailyChange":-0.17,"quantity":40.0,"sector":"Retail"},{"ticker":"V","companyName":"Visa Inc.","price":250.6,"dailyChange":-0.02,"quantity":55.0,"sector":"Finance"},{"ticker":"PG","companyName":"Procter & Gamble Co.","price":135.0,"dailyChange":-0.13,"quantity":100.0,"sector":"Consumer Goods"},{"ticker":"MA","companyName":"Mastercard Incorporated","price":390.1,"dailyChange":0.12,"quantity":25.0,"sector":"Finance"},{"ticker":"INTC","companyName":"Intel Corporation","price":55.25,"dailyChange":-0.32,"quantity":80.0,"sector":"Technology"},{"ticker":"CRM","companyName":"Salesforce","price":280.0,"dailyChange":0.32,"quantity":45.0,"sector":"Technology"},{"ticker":"VZ","companyName":"Verizon Communications Inc.","price":55.5,"dailyChange":0.41,"quantity":70.0,"sector":"Telecommunications"},{"ticker":"KO","companyName":"The Coca-Cola Company","price":55.75,"dailyChange":-0.05,"quantity":120.0,"sector":"Consumer Goods"}]
  //let cashComponent = "200000"
  const [cashComponent, setCashComponent] = useState(200000);
  const updateCashComponent = (amount) => {
    setCashComponent((prevCash) => prevCash + amount);
  }
  const formatPortData = [["Ticker", "Price"]]
  const formatSectorData = [["Ticker", "Price"]]
  let tempSectorSummer = {}
  let myBalance = 0 
  let portfolioValue = 0
  let totalPnL = 0
  
  data.forEach((stock)=>{
    formatPortData.push([stock["ticker"],stock["quantity"]*stock["price"]])
    portfolioValue += stock["quantity"]*stock["price"]
    totalPnL += stock["dailyChange"]*stock["quantity"]*stock["price"]

    if(stock["sector"] in tempSectorSummer){
      tempSectorSummer[stock["sector"]]+=1
    }
    else{tempSectorSummer[stock["sector"]]=1}
  })
  formatPortData.push(["Cash",parseFloat(cashComponent)])

  let keys = Object.keys(tempSectorSummer)
  keys.forEach(value=>{
    formatSectorData.push([value,tempSectorSummer[value]])
  })

  myBalance += portfolioValue + parseFloat(cashComponent)

  
  return (
    
    <div className="App">
      <div className="logo">
        <img src="https://www.rbcroyalbank.com/dvl/v1.0/assets/images/logos/rbc-logo-shield.svg"  width="48" height="60" alt="RBC"></img>
        <img src={tradesense} height="60" alt="Tradesense Logo"></img>
        <img src={moreinfo} style={{position:"relative", marginLeft:'auto',marginRight:"10px", top:'15px'}} width="30" height="30" alt="moreinfo"></img>
      </div>
      <div className="App-header">
        <Watchlist data={data} updateCash={updateCashComponent}/>
        <div className="overview">
          <div className="summary">
            <Summary_component value={(Math.round(myBalance*100)/100).toLocaleString("en-US")} title="My Balance"/>
            <Summary_component value={(Math.round(parseFloat(cashComponent)*100)/100).toLocaleString("en-US")} title="Cash Balance"/>
            <Summary_component value={(Math.round(portfolioValue*100)/100).toLocaleString("en-US")} title="Profolio Value"/>
            <Summary_component value={(Math.round(totalPnL*100)/100).toLocaleString("en-US")} title="Total P/L"/>
          </div>
          <div className = "charts-block">
            <div className="charts-overview">
              <div className="summary_component_title"><u>Porfolio Daily Performance - Last 30 days</u></div>
              <Chart
                chartType="LineChart"
                width="750px"
                height="450px"
                data={performanceData}
                options={line_chart_options}
                style = {{marginLeft:"10px"}}
                />
            </div>
            <div className="charts-overview">
              <div className="chart-formular">
                <div className="summary_component_title"><u>Porfolio Components</u></div>
                <Chart
                  chartType="PieChart"
                  width="180px"
                  height="180px"
                  data={formatPortData}
                  options={options}
                  style = {{margin:"20px"}}
                />
              </div>
              <div className="chart-formular">
                <div className="summary_component_title"><u>Portfolio Sectors</u></div>
                <Chart
                  chartType="PieChart"
                  width="180px"
                  height="180px"
                  data={formatSectorData}
                  options={options}
                  style = {{margin:"20px"}}
                />
              </div>  
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
