//在此处的都是全局变量，import即可使用，导入名.属性即可使用
//注意 ：：：每个属性都需要备注
 class GlobleData{
    constructor(){
        this.text = ["xiaofeng","asd"];
        this.Bnum = 10;
    }
    setText=(value) => this.text=value
    
}
export default(new GlobleData);