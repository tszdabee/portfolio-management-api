import './watchlist.css';
function Watchlist(props){
    const data = props.data
    console.log(data)

    return(
        <div className="watchlist-container">{
            data.foreach((stock, index) =>{
                    <div className = {(index%2==0?"odd-box":"even-box")}>
                        {stock["ticker"]+stock["name"]+stock["price"]+stock["priceChange"]+stock["shares"]}
                    </div>
            })
        }</div>
    )
}