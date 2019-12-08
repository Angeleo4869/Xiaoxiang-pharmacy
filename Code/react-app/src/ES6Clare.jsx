import React from 'react';//���ڴ������
import PropTypes from 'prop-types';//���ڵ��� prop-types ģ�飬ʹ�����ܹ��������ͼ��ķ�����Ϊ props �������͡�
import Card from '@material-ui/core/Card';
import CardActionArea from '@material-ui/core/CardActionArea';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';


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
        return(
            <div>
                <div style={{display:"flex"}}>
                    <Link  to="/GoodsDetails?name=xiaofeng&age=18">
                        <Card style={{width:'90%'}}>
                            <CardActionArea>
                            
                                <CardMedia
                                component="img"
                                alt="Contemplative Reptile"
                                height="140"
                                image="/Pic/D1.jpg"
                                title="Contemplative Reptile"
                                />
                                <CardContent>
                                <Typography gutterBottom variant="h5" component="h2">
                                    Lizard
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging
                                    across all continents except Antarctica
                                </Typography>
                                </CardContent>
                            </CardActionArea>
                        </Card>
                    </Link>
                    <Link  to="/GoodsDetails?name=dafeng&age=19">
                        <Card style={{width:'90%'}}>
                            <CardActionArea>
                            
                                <CardMedia
                                component="img"
                                alt="Contemplative Reptile"
                                height="140"
                                image="/Pic/D1.jpg"
                                title="Contemplative Reptile"
                                />
                                <CardContent>
                                <Typography gutterBottom variant="h5" component="h2">
                                    Lizard
                                </Typography>
                                <Typography variant="body2" color="textSecondary" component="p">
                                    Lizards are a widespread group of squamate reptiles, with over 6,000 species, ranging
                                    across all continents except Antarctica
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