import React from 'react';//
import PropTypes from 'prop-types';//
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import cookie from 'react-cookies'

import {Link} from 'react-router-dom';
class Welcome extends React.Component{
    constructor(props){
        super(props);
        this.state = {user:''};
        this.handleClick = this.handleClick.bind(this);//��this����Ա����
    }

    // static defaultProps = {
    //     name: 'shiyanlou'
    // }

    // static propTypes = {
    //     name: React.PropTypes.string
    // }

    handleClick(){
        console.log(this);
    }


    render(){
        var user = "";
        if(cookie.load('userId')!=null){
            user = cookie.load('userId');
        }else{
            user = "tourist";
        }
        return(
            <div>
                <div style={{display:"flex",maxWidth:800}}>
                    <Link  to={"/GoodsDetails?name=" + user + "&goodid=2"}>
                        <Card style={{width:'90%',maxWidth:600}}>
                            <CardActionArea>
                                <CardMedia
                                component="img"
                                alt="Contemplative Reptile"
                                height="140"
                                image="/Pic/D1.jpg"
                                title="Contemplative Reptile"
                                />
                                <CardContent>
                                <Typography gutterBottom noWrap={true} variant="h5" component="h2">
                                    伸腿瞪眼丸
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    ￥9.9
                                </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Link>
                    <Link  to={"/GoodsDetails?name=" + user + "&goodid=3"}>
                        <Card style={{width:'90%',maxWidth:600}}>
                            <CardActionArea>
                            
                                <CardMedia
                                component="img"
                                alt="Contemplative Reptile"
                                height="140"
                                image="/Pic/D1.jpg"
                                title="Contemplative Reptile"
                                />
                                <CardContent>
                                <Typography gutterBottom noWrap={true} variant="h5" component="h2">
                                    通宵胫骨贴
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    ￥9.9
                                </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Link>
                </div>
                    <h1>Hello,{this.props.name}</h1>
                    <h2>Have a nice time!</h2>
                <Link to="/PersonCenter">
                    <button onClick={this.handleClick}>click me!</button>
                </Link>
                <Link to="/Login">
                    <button onClick={this.handleClick}>click me!</button>
                </Link>
                <Link to="/Register">
                    <button onClick={this.handleClick}>click me!</button>
                </Link>
                <Link to="/XXYFReactManagement">
                    <button onClick={this.handleClick}>BG!</button>
                </Link>
                <Link to="/Shop">
                    <button onClick={this.handleClick}>shap!</button>
                </Link>
                <Link to="/ShopView">
                    <button onClick={this.handleClick}>shapView!</button>
                </Link>
                <Link to="/ImedPurchase">
                     <Button>立即购买</Button>
                </Link>

            </div>
        );
    }
}

//propTypes 
Welcome.propTypes = {
    name: PropTypes.string
};
//defaultProps �������� props ��Ĭ��ֵ
Welcome.defaultProps = {
    name: 'Welcom to 潇湘药房'
}
export default Welcome;