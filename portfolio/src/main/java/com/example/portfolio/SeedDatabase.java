package com.example.portfolio;

import com.example.portfolio.model.Index;
import com.example.portfolio.model.Stock;
import com.example.portfolio.model.repository.StockRepository;
import com.example.portfolio.model.repository.IndexRepository;
import com.example.portfolio.model.ETF;
import com.example.portfolio.model.repository.ETFRepository;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeedDatabase {

    @Autowired
    private StockRepository repository1;

    @Autowired
    private ETFRepository repository2;  
  
    @Autowired
    private IndexRepository indexRepo;

    @PostConstruct
    public void init() {
        repository1.save( new Stock("NFLX" ,"Netflix Inc.", 425.50, -0.45, 15.0, "Technology") );
        repository1.save( new Stock("BABA" ,"Alibaba Group Holding LTD", 98.2, -0.45, 55.0, "Technology") );
        repository1.save( new Stock("AAPL" ,"Apple Inc.", 150.50, -0.33, 50.0, "Technology") );
        repository1.save( new Stock("GOOGL" ,"Alphabet Inc.", 127.20, 0.18, 50.0, "Technology") );
        repository1.save( new Stock("AMZN" ,"Amazon.com Inc.", 127.75, -0.48, 50.0, "Technology") );
        repository1.save( new Stock("MSFT" ,"Microsoft Corporation", 290.40, -0.21, 60.0, "Technology") );
        repository1.save( new Stock("TSLA" ,"Tesla", 700.00, 0.38, 30.0, "Automotive") );
        repository1.save( new Stock("JPM" ,"JPMorgan Chase & Co.", 150.80, 0.17, 45.0, "Finance") );
        repository1.save( new Stock("NVDA" ,"NVIDIA Corporation", 220.30, -0.10, 30.0, "Technology") );
        repository1.save( new Stock("WMT" ,"Walmart Inc.", 140.10, 0.32, 50.0, "Retail") );
        repository1.save( new Stock("JNJ" ,"Johnson & Johnson", 170.25, 0.43, 40.0, "Healthcare") );
        repository1.save( new Stock("BAC" ,"Bank of America Corporation", 40.50, -0.16, 70.0, "Finance") );
        repository1.save( new Stock("XOM" ,"Exxon Mobil Corporation", 60.70, 0.07, 35.0, "Energy") );
        repository1.save( new Stock("PFE" ,"Pfizer Inc.", 45.80, 0.21, 100.0, "Healthcare") );
        repository1.save( new Stock("HD" ,"The Home Depot", 350.90, -0.17, 20.0, "Retail") );
        repository1.save( new Stock("V" ,"Visa Inc.", 250.60, -0.02, 20.0, "Finance") );
        repository1.save( new Stock("PG" ,"Procter & Gamble Co.", 135.00, -0.13, 50.0, "Consumer Goods") );
        repository1.save( new Stock("MA" ,"Mastercard Incorporated", 390.10, 0.12, 12.0, "Finance") );
        repository1.save( new Stock("INTC" ,"Intel Corporation", 55.25, -0.32, 40.0, "Technology") );
        repository1.save( new Stock("CRM" ,"Salesforce", 280.00, 0.32, 20.0, "Technology") );
        repository1.save( new Stock("VZ" ,"Verizon Communications Inc.", 55.50, 0.41, 35.0, "Telecommunications") );
        repository1.save( new Stock("KO" ,"The Coca-Cola Company", 55.75, -0.05, 60.0, "Consumer Goods") );
        repository2.save(new ETF("QQQ", "Invesco QQQ Trust", 100.0, 320.0, 32000.0, 375.0, 37500.0, 17.19, 5500.0,
                0.56, 35.87, 1.05, 0.18, "Technology"));
        repository2.save(new ETF("SPY", "SPDR S&P 500 ETF Trust", 50.0, 400.0, 20000.0, 420.0, 21000.0, 10.0, 1000.0,
                1.29, 33.95, 1.0, 0.15, "Large Cap Blend"));
        repository2.save(new ETF("IWM", "iShares Russell 2000 ETF", 70.0, 220.0, 15400.0, 230.0, 16100.0, 14.29, 1700.0,
                1.11, 46.32, 1.03, 0.20, "Small Cap Blend"));
        repository2.save(new ETF("VTI", "Vanguard Total Stock Market ETF", 80.0, 230.0, 18400.0, 250.0, 20000.0, 8.7, 1600.0,
                1.39, 35.85, 1.0, 0.16, "Large Cap Blend"));
        repository2.save(new ETF("EFA", "iShares MSCI EAFE ETF", 60.0, 70.0, 4200.0, 80.0, 4800.0, 90.48, 600.0,
                3.0, 25.12, 1.02, 0.15, "International Equity"));
        repository2.save(new ETF("EEM", "iShares MSCI Emerging Markets ETF", 40.0, 40.0, 1600.0, 45.0, 1800.0, 81.25, 200.0,
                1.74, 28.36, 1.01, 0.17, "Emerging Markets Equity"));
        repository2.save(new ETF("IYR", "iShares U.S. Real Estate ETF", 30.0, 100.0, 3000.0, 110.0, 3300.0, 10.0, 300.0,
                3.4, 35.45, 1.09, 0.20, "Real Estate"));
        repository2.save(new ETF("XLF", "Financial Select Sector SPDR Fund", 120.0, 30.0, 3600.0, 38.0, 4560.0, 6.67, 960.0,
                1.71, 39.20, 0.96, 0.14, "Financials"));
        repository2.save(new ETF("XLY", "Consumer Discretionary Select Sector SPDR Fund", 60.0, 180.0, 10800.0, 200.0, 12000.0,
                8.33, 1200.0, 0.84, 32.84, 0.95, 0.16, "Consumer Discretionary"));
        repository2.save(new ETF("XLI", "Industrial Select Sector SPDR Fund", 50.0, 100.0, 5000.0, 110.0, 5500.0, 10.0, 500.0,
                1.76, 37.48, 0.95, 0.15, "Industrials"));
        repository2.save(new ETF("IYH", "iShares U.S. Healthcare ETF", 25.0, 250.0, 6250.0, 275.0, 6875.0, 10.0, 625.0,
                1.49, 23.65, 0.82, 0.14, "Healthcare"));
        repository2.save(new ETF("IYW", "iShares U.S. Technology ETF", 40.0, 160.0, 6400.0, 190.0, 7600.0, 18.75, 1200.0,
                0.82, 31.77, 0.95, 0.18, "Technology"));
        repository2.save(new ETF("TAN", "Invesco Solar ETF", 60.0, 50.0, 3000.0, 60.0, 3600.0, 20.0, 600.0,
                0.57, 29.47, 1.22, 0.21, "Renewable Energy"));
        repository2.save(new ETF("ICLN", "iShares Global Clean Energy ETF", 75.0, 30.0, 2250.0, 33.0, 2475.0, 46.67, 525.0,
                0.81, 27.61, 1.22, 0.20, "Renewable Energy"));
        repository2.save(new ETF("ARKK", "ARK Innovation ETF", 25.0, 120.0, 3000.0, 150.0, 3750.0, 25.0, 750.0,
                0.0, 35.36, 1.20, 0.21, "Technology"));
        repository2.save(new ETF("ARKG", "ARK Genomic Revolution ETF", 30.0, 150.0, 4500.0, 160.0, 4800.0, 6.67, 300.0,
                0.0, 27.84, 1.08, 0.19, "Healthcare"));
        repository2.save(new ETF("IAU", "iShares Gold Trust", 20.0, 120.0, 2400.0, 140.0, 2800.0, 16.67, 400.0,
                0.0, 8.21, 0.0, 0.09, "Precious Metals"));
        repository2.save(new ETF("PGX", "Invesco Preferred ETF", 100.0, 14.0, 1400.0, 15.0, 1500.0, 7.14, 100.0,
                3.27, 5.59, 0.34, 0.11, "Preferred Stock"));
        repository2.save(new ETF("LQD", "iShares iBoxx $ Investment Grade Corporate Bond ETF", 50.0, 120.0, 6000.0, 130.0, 6500.0,
                8.33, 500.0, 2.42, 5.79, 0.54, 0.09, "Corporate Bonds"));
        repository2.save(new ETF("HYG", "iShares iBoxx $ High Yield Corporate Bond ETF", 80.0, 90.0, 7200.0, 105.0, 8400.0,
                16.67, 1200.0, 4.95, 5.10, 0.97, 0.10, "High Yield Bonds"));
        repository2.save(new ETF("TLT", "iShares 20+ Year Treasury Bond ETF", 30.0, 150.0, 4500.0, 160.0, 4800.0,
                6.67, 300.0, 1.47, 8.01, 0.63, 0.13, "U.S. Treasury Bonds"));
            indexRepo.save( new Index("GSPTSE","S&P/TSX Composite",20176.27,-1.74,100.00,"Sell") );
            indexRepo.save( new Index("SPTSE","S&P/TSX 60",1209.70,-1.78,25.00,"Strong Sell") );
            indexRepo.save( new Index("DJI","Dow Jones Industrial Average",35384.78,-0.69,50.00,"Strong Buy") );
            indexRepo.save( new Index("US500","S&P 500",4516.38,-1.32,0.00,"Neutral") );
            indexRepo.save( new Index("IXIC","NASDAQ Composite",13954.39,-2.31,25.00,"Sell") );
            indexRepo.save( new Index("US2000","Russell 2000",1959.60,-1.73,0.00,"Strong Buy") );
            indexRepo.save( new Index("VIX","CBOE Volatility Index",16.14,15.87,0.00,"Buy") );
            indexRepo.save( new Index("BVSP","Bovespa",120383.00,-0.71,50.00,"Buy") );
            indexRepo.save( new Index("MXX","S&P/BMV IPC",53554.13,-1.21,78.00,"Strong Sell") );
            indexRepo.save( new Index("DE40","DAX",16020.02,-1.36,35.00,"Sell") );
            indexRepo.save( new Index("UK100","FTSE 100",7561.23,-1.37,100.00,"Strong Sell") );
            indexRepo.save( new Index("FCHI","CAC 40",7312.84,-1.26,120.00,"Strong Sell") );
            indexRepo.save( new Index("STOXX50","Euro Stoxx 50",4336.85,-1.60,50.00,"Sell") );
            indexRepo.save( new Index("AEX","AEX",775.03,-1.41,25.00,"Neutral") );
            indexRepo.save( new Index("ES35","IBEX 35",9328.70,-1.83,0.00,"Strong Sell") );
            indexRepo.save( new Index("IT40","FTSE MIB",28981.00,-1.28,88.00,"Buy") );
            indexRepo.save( new Index("SWI20","SMI",11219.50,-0.79,100.00,"Neutral") );
            indexRepo.save( new Index("PSI20","PSI",5978.99,-1.67,110.00,"Strong Sell") );
            indexRepo.save( new Index("BFX","BEL 20",3719.80,-1.21,50.00,"Neutral") );
            indexRepo.save( new Index("ATX","ATX",3181.74,-1.43,60.00,"Sell") );
            indexRepo.save( new Index("OMXS30","OMX Stockholm 30",2222.74,-0.78,20.00,"Strong Sell") );
            indexRepo.save( new Index("IMOEX","MOEX Russia",3106.46,0.41,0.00,"Strong Buy") );
            indexRepo.save( new Index("IRTS","RTSI",1040.15,-1.48,120.00,"Strong Buy") );
            indexRepo.save( new Index("WIG20","WIG20",2142.82,-2.10,130.00,"Buy") );
            indexRepo.save( new Index("BUX","Budapest SE",53823.23,0.84,30.00,"Strong Buy") );
            indexRepo.save( new Index("XU100","BIST 100",7258.54,1.26,70.00,"Strong Buy") );
            indexRepo.save( new Index("TA35","TA 35",1862.35,0.04,25.00,"Buy") );
            indexRepo.save( new Index("TASI","Tadawul All Share",11478.28,-1.36,50.00,"Strong Sell") );
            indexRepo.save( new Index("JP225","Nikkei 225",32707.50,-2.27,100.00,"Buy") );
            indexRepo.save( new Index("AXJO","S&P/ASX 200",354.60,-1.29,25.00,"Strong Buy") );
            indexRepo.save( new Index("SSEC","Shanghai Composite",3261.69,-0.89,40.00,"Strong Buy") );
            indexRepo.save( new Index("SZI","SZSE Component",11104.16,-0.35,80.00,"Strong Buy") );
            indexRepo.save( new Index("FTXIN9","FTSE China A50",13115.05,-1.04,20.00,"Strong Buy") );
            indexRepo.save( new Index("DJSH","Dow Jones Shanghai",460.88,-0.67,0.00,"Strong Buy") );
            indexRepo.save( new Index("HK50","Hang Seng",19514.00,-2.48,0.00,"Strong Buy") );
            indexRepo.save( new Index("TWII","Taiwan Weighted",17212.87,0.39,30.00,"Buy") );
            indexRepo.save( new Index("KS11","KOSPI",2616.47,-1.90,80.00,"Strong Buy") );
            indexRepo.save( new Index("JKSE","Jakarta Stock Exchange Composite Index",6854.51,-0.46,60.00,"Neutral") );
            indexRepo.save( new Index("NSEI","Nifty 50",19526.55,-1.05,30.00,"Neutral") );
            indexRepo.save( new Index("BSESN","BSE Sensex 30",65782.78,-1.02,50.00,"Neutral") );
            indexRepo.save( new Index("VNI30","VN 30",1221.32,-0.07,50.00,"Strong Buy") );
    }
}
