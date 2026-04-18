void rightRotate(){
  bool flag = false;
  while(1){

    qtr.readLineBlack(sv);
    for(int i = 0; i < 12; i++){
      svBackUp[i] = sv[i];
    }
    if(whiteLine==0){
    for(int i=0 ;i<12; i++){
      sv[i]=(sv[i]>high);
      }
    }
    else if(whiteLine==1){
      for(int i=0 ;i<12; i++){
      sv[i]=(sv[i]<low);
      }
    }
    // if(whiteEN==1)lineChange(); `
    md(M1,ACW,rotationSpeed);md(M2,CW,rotationSpeed);
    if(sv[11]){flag = true;}
    if(flag && (sv[7] || sv[6])){
      motorBrake();
      break;
    }
  }
}
