package com.betaquestionapp.hoixoaydapxoay;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Random;

public class QuestionActivity extends MainActivity {
    //extend numberQuestion + number left trong mainactivity
    //    TextView txtNumberLeft, txtQuestion;
    Button btnA, btnB, btnC, btnD;
    ArrayList<Questions> arrayQuestion, arrayTanGai, arrayToan;

    ImageButton btnSettingMenu;

    TextView txtQuestion, txtNumberLeft;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_question );
        mAdView = (AdView) findViewById( R.id.adView );
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd( adRequest );

        Anhxa();

        //--------------CODE-------------
        txtNumberLeft.setText( numberLeft + " " );
        setQuestion( numberQuestionPack );
        //nếu case là 1



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.menu_questionactivity, menu );
        return super.onCreateOptionsMenu( menu );
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuManHinhChinh:
                Intent intent = new Intent( QuestionActivity.this, MainActivity.class );
                startActivity( intent );
                break;

            case R.id.menuRateUs:
                break;

            case R.id.selectMacDinh:
                numberQuestionPack = 1;
                numberQuestion = 0;
                numberLeft = 3;

                setQuestion( numberQuestionPack );
                break;

            case R.id.selectToanHoc:
                numberQuestionPack = 2;
                numberQuestion = 0;
                numberLeft = 3;

                setQuestion( numberQuestionPack );
                break;

            case R.id.selectTinhYeu:
                numberQuestionPack = 3;
                numberQuestion = 0;
                numberLeft = 3;

                setQuestion( numberQuestionPack );
                break;

        }

        return super.onOptionsItemSelected( item );
    }

    public void Anhxa() {
        btnSettingMenu = findViewById( R.id.imagebuttonsettingMenu );
        txtNumberLeft = findViewById( R.id.textviewNumberLeft );
        txtQuestion = findViewById( R.id.textviewQuestion );
        btnA = findViewById( R.id.buttonA );
        btnB = findViewById( R.id.buttonB );
        btnC = findViewById( R.id.buttonC );
        btnD = findViewById( R.id.buttonD );

        arrayQuestion = new ArrayList<>();

        arrayQuestion.add( new Questions( "câu 1: Có 3 bác sĩ nói rằng Sơn là em trai của họ, nhưng Sơn lại bảo anh chẳng có người anh trai nào cả.Vậy ai là người nói dối?", "3 bác sĩ nói dối", "Không có ai nói dối cả", "Chỉ có Sơn nói dối", "Sơn và 3 bác sĩ đều nói dối", "Không có ai nói dối cả vì 3 người bác sĩ đó là 3 chị gái của Sơn.", R.drawable.quyensachkienthuc ) );//0A
        arrayQuestion.add( new Questions( "câu 2: Cái gì giúp bạn nhìn thẳng qua tường nhà", "Không có cái nào có thể nhìn qua tường", "Lỗ hổng trên tường ", "Cửa sổ", "Kính xuyên thấu", "CỬA SỔ", R.drawable.cuaso1 ) );//1B
        arrayQuestion.add( new Questions( "câu 3: Cái gì mà đi thì nằm, đứng cũng nằm, nhưng nằm lại đứng?", "Con Rắn", "Bàn Chân", "Con giun", "Con đường", "Khi nằm thì chân dựng lên", R.drawable.quyensachkienthuc ) );//2C
        arrayQuestion.add( new Questions( "câu 4: Con chó đen gọi là con chó mực. Con chó vàng gọi là con chó phèn. Con chó sanh gọi là con chó đẻ. Vậy con chó đỏ gọi là con chó gì? ", "Con chó quay", "Con chó Red", "Con chó đỏ", "Con chó hồng", "Gọi là CHÓ ĐỎ vì nó có màu đỏ", R.drawable.quyensachkienthuc ) );//3D
        arrayQuestion.add( new Questions( "câu 5: Nắng ba năm tôi ko bỏ bạn, mưa 1 ngày sao bạn lại bỏ tôi. Là cái gì?", "Cái bóng", "Mặt trời", "người yêu cũ", "bạn thân", "Cái Bóng", R.drawable.bong2 ) );//4A
        arrayQuestion.add( new Questions( "câu 6: Trên nhấp dưới giật là đang làm gì? ", "Kéo Co", "Câu cá", "Chơi Bập bênh", "...", "Không nghĩ bậy nha :))", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 7: Con gì mang được miếng gỗ lớn nhưng ko mang được hòn sỏi?  ", "Con đường", "Con kiến", "Con voi", "Con Sông", "CON SÔNG ", R.drawable.song1 ) );//4A
        arrayQuestion.add( new Questions( "câu 8: Cái gì chứa nhiều nước nhất mà ko ướt tí tí nào? ", "Túi chống nước", "Giấy chống nước", "Bong bóng", "Bản đồ", " Nước chứ không phải nước ", R.drawable.bando ) );//4A
        arrayQuestion.add( new Questions( "câu 9: Con gì đi ngồi, đứng ngồi, nằm ngồi, 'ngồi' cũng ngồi ", "Con đường", "Con Rắn", "Ếch", "Con giun", "CON ẾCH", R.drawable.ech1 ) );//4A
        arrayQuestion.add( new Questions( "câu 10: Có người mang 3 quả tim mà vẫn được xem là người bình thường. Đó là ai? ", "Người ngoài hành tinh", "Bà mẹ mang thai cặp song sinh", "Xmen", "Bạn", "Bà mẹ mang thai cặp song sinh", R.drawable.mom ) );//4A
        arrayQuestion.add( new Questions( "câu 11: Có 2 con chó ở công viên. Con chó trắng tên Đen, con chó đen tên Trắng. Nam thấy chúng dễ thương, liền ném trái banh ra xa rồi ra lệnh 'Đen đi lượm trái banh' Vậy con chó nào sẽ đi lượm?", "Không có con chó nào lượm cả", "con chó Trắng", "Con chó Đen", "Cả 2 con đều lượm", "Không con nào cả, vì Nam không phải chủ của chúng", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 12: Tôi có 4 cái chân, 1 cái lưng, nhưng không có cơ thể. Tôi là ai? ", "Cái Kiềng", "Con sứa", "Cái ghế", "Cái giường", "Cái Ghế ", R.drawable.chair ) );//4A
        arrayQuestion.add( new Questions( "câu 13: Cái gì mà khi đập vỡ nó thì có một chất lỏng chảy ra, và đun nóng chất lỏng đó thì lại thu được một chất rắn? ", "Bột nở", "Quả Trứng", "Cao su", "Thép", "Quả Trứng", R.drawable.egg ) );//4A
        arrayQuestion.add( new Questions( "câu 14: Ngôn ngữ nào trên thế giới không phát ra âm thanh? ", "Tiếng Ấn độ", "Tiếng ngoài hành tinh", "Tiếng Anh", "Cơ thể", "Ngôn ngữ cơ thể", R.drawable.bodylanguage ) );//4A
        arrayQuestion.add( new Questions( "câu 15: Cái gì để càng lâu càng thấp ", "cây nến", "Cây kem", "Con cua", "Cây Tre", " Cây nến thắp lên thì mới thấp(chảy) xuống được! Còn cây Kem thì không cần tác động", R.drawable.kem ) );//4A
        arrayQuestion.add( new Questions( "câu 16: Hai thứ gì chúng ta không thể ăn vào bữa tối? ", "Thịt Gà", "Bánh mì", "Xôi", "Bữa sáng và bữa trưa", "Đương nhiên không thể ăn sáng, ăn trưa khi đang ăn tối :)) ", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 17: Làm cách nào để luôn tỉnh táo sau 8 ngày không ngủ?", "Ngủ Đêm", "Tập Thể dục", "Uống nhiều nước", "Ăn nhiều", "8 'Ngày' Không ngủ thì ngủ vào ban Đêm", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 18: Kết Quả của phép tính 7+7:7+7x7-7 bằng bao nhiêu?", "46", "40", "56", "50", "Nhân chia trước cộng trừ sau!", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 19: Theo luật Scotland, một người đàn ông có thể lấy em gái của bà vợ góa của anh ta không? ", "Có Thể", "Không Thể", "Click để thêm lượt chơi:v", "Click để mất một lượt chơi :v", "'Bà vợ góa của Ông ta' nghĩa là ông ta đã chết! Người chết thì không làm gì được.", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 20: Có 3 quả táo, bạn lấy đi hai quả. vậy bạn có bao nhiêu quả táo?  ", "Không có quả nào", "1 quả ", "3 quả", "2 Quả", "Bạn lấy 2 quả thì bạn có 2 quả", R.drawable.apple ) );//4A
        arrayQuestion.add( new Questions( "câu 21: Bác sĩ đưa cho bạn 3 viên thuốc và bảo bạn cứ 30 phút thì uống một viên. Vậy, chúng còn tồn tại trong bao nhiêu phút? ", "30", "90", "60", "3", "60 phút.Vì ban đầu uống 1 viên, 30 phút sau uống viên tiếp theo, rồi 30 phút sau uống viên còn lại", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 22: Một người nông dân có 17 con cừu, Trừ 9 con còn lại chết hết. Vậy, ông ta còn lại bao nhiêu con? ", "8", "17", "26", "9", "Nếu 9 con kia không chết thì Người nông dân có 26 con", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 23: 1+1+1+1+1\n" + "       1+1+1+1+1\n" + "       1+1x0+1 = ?\n ", "30", "12", "13", "1", "Không có dấu cộng ở cuối dòng thứ nhất và thứ hai. Như vậy, ta được phương trình:\n" + "\n" + "1 +1 +1 +1 +11 +1 +1 +1 +11 +1 x 0 +1 = 30", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 24: Cầm cái gì càng lâu thì càng mất nhiều tiền?", "tiền", "đồ", "vàng", "trang sức", "Cầm đồ", R.drawable.camdo ) );//4A
        arrayQuestion.add( new Questions( "câu 25: Cái gì khi xài thì quăng đi, không xài thì lấy lại? ", "Tiền ", "Bóng chuyền", "Mỏ neo", "Boomerang", "MỎ NEO", R.drawable.moneo1 ) );//4A
        arrayQuestion.add( new Questions( "câu 26: Tôi đi khắp thế giới mà vẫn ở nguyên một chỗ, tôi là ai? ", "Game thủ", "Bản đồ", "Đôi giày", "con Tem", "Tem luôn được gắn ở lá Thư cho dù chuyển đi khắp nơi", R.drawable.tem ) );//4A
        arrayQuestion.add( new Questions( "câu 27: Tại sao người Trung Quốc ăn nhiều hơn người Nhật? ", "Thức ăn trung quốc ngon hơn Nhật Bản", "Tại vì Thức ăn ở Nhật Chủ yếu là cá", "Tại vì người Trung Quốc có nhiều trang trại.", "Tại vì người Trung Quốc đông dân hơn.", "Dân số Trung Quốc gấp nhiều lần Nhật Bản, nên dĩ nhiên người Trung Quốc Ăn nhiều hơn", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 28: cây nhang đốt càng nhiều càng ngắn, vậy có cái gì đốt càng nhiều càng dài không? ", "Kem", "Cây Tre", "Cây Nến", "Cái đũa", " Cây tre trăm đốt :v", R.drawable.tre ) );//4A
        arrayQuestion.add( new Questions( "câu 29: Đá quả bóng cách xa 6 mét, làm thể nào để quả bóng tự động quay về vị trí cũ mặc dù trên đường đi quả bóng không gặp lực cản ", "Nhờ Người bạn cách đó 6 mét đá lại", "Đá quả bóng vào tường", "Không thể làm được", "Đá quả bóng lên trời, theo Phương vuông góc", " Đá lên trời theo hướng vuông góc với mặt đất. Với tác dụng của trọng lực, quả bóng sẽ quay trở lại", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 30: Cây cầu có trọng tải 10 tấn, vượt quá trọng tải thì sẽ sập, Có một chiếc xe tải chở hàng, xe nặng 8 tấn + 4 tấn hàng. Làm thế nào để bác tài xế đi qua được?", "Bỏ xe và hàng lại", "Bỏ hàng lại", "Chỉ cần bỏ xe và vác hàng qua", "Cứ đi thôi :v", "Yêu cầu của Câu hỏi chỉ cần bác tài xế có đi qua cầu thôi. Thế nên bác cứ thế mà bước qua cầu, để xe và hàng hóa ở lại thôi.", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 31: Môn học nào khiến nhiều giáo viên và học sinh phải bó tay nhất? ", "Hóa", "Giáo dục quốc phòng", "Sinh học", "Toán", "Trong môn GDQP được học ở cấp 3 có tiết CỐ ĐỊNH XƯƠNG GÃY", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 32: ‘Trên đầu đội sắc vua ban\n" + "Dưới thì yếm thắm,dây vàng xum xoe\n" + "Thần linh đã gọi thì về\n" + "Ngồi trên mâm ngọc, gươm kề sau lưng’ là gì?\n", "Mâm ngũ quả", "Thái Hậu", "Gà trống cúng", "Vua", "Gà Trống Cúng ", R.drawable.chicken ) );//4A
        arrayQuestion.add( new Questions( "câu 33: ‘Đêm thân che nắng cho đời \n" + "Rồi ra mang tiếng là người chả khôn?’\n" + "Là gì?\n", "Mái nhà", "Cánh cửa", "Mành che cửa", "Cái Mũ", "Mành Che Cửa ", R.drawable.manhcua ) );//4A
        arrayQuestion.add( new Questions( "câu 34: Một chiếc xe tải đi vào làng và gặp 4 chiếc ô tô. Có bao nhiêu xe đi vào làng? ", "Không có xe nào", "4 chiếc", "5 Chiếc", "1 Chiếc", "Xe tải đi vào làng và gặp 4 chiếc ô tô, nên 4 chiếc ô tô đi ra khỏi làng", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 35: Ai thực hiện sự di chuyển trong khi đang ngồi? ", "Bàn chân", "Con ếch", "Người chơi cờ", "Không thể làm điều đó được!", "Người Chơi Cờ", R.drawable.chess ) );//4A
        arrayQuestion.add( new Questions( "câu 36: Một Người đi Lên cầu thang bộ dài 40 bậc bằng cách tiến một bước rồi lùi một bước. Hỏi sau bao lâu người đó đi hết cầu thang? Biết rằng trung bình mỗi bước đi hết 5 giây ", "205s", "200s", "không bao giờ bước lên bậc thang thứ 2", "300s", "Đầu tiên là bước xuôi, sau đó quay người lại để bước lùi => mất 40x5=200s", R.drawable.cauthang ) );//4A
        arrayQuestion.add( new Questions( "câu 37: Nhìn ảnh mặt trời có chói mắt không?", "Không", "Không,nếu tôi đeo kính râm", "Có", "Không, tôi bị mù", "Không có tấm ảnh nào khiến chúng ta chói mắt", R.drawable.mattroi ) );//4A
        arrayQuestion.add( new Questions( "câu 38: Cái gì vô hạn?", "Sự Hư cấu", "Vũ trụ", "Con số", "Kiến thức", "Con Số", R.drawable.pi ) );//4A
        arrayQuestion.add( new Questions( "câu 39: Có một người dẫn một 'đàn heo' đi qua đường. Vậy người đó tên gì ", "Trang", "Xuân", "Hương", "Linh", "Heo đi qua đường là Hương đi qua đèo. ", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 40: Ngày 11/9 là ngày gì?  ", "Ngày khủng bố đáng sợ ở Mỹ", "Ngày Bình thường ", "Ngày sinh của một ai đó", "Tất cả đều đúng", "Tra google nhanh thế!", R.drawable.ngaydo ) );//4A
        arrayQuestion.add( new Questions( "câu 41: Nhất quỷ, nhì ma, thứ 3 học trò. Vậy thứ 4 là gì? ", "Không quan tâm", "Phụ Huynh", "Thứ 4", "Giám thị", "Thứ 4: Một ngày bình thường trong tuần", R.drawable.thu4 ) );//4A
        arrayQuestion.add( new Questions( "câu 42: Bố vợ của em rể của chồng chị dâu ta gọi bằng gì? ", "Dượng", "Bố :v", "Cậu", "Chú", "Father", R.drawable.bo ) );//4A
        arrayQuestion.add( new Questions( "câu 43: Bố mẹ có 6 người con trai, mỗi người con trai có 2 cô em gái, mỗi cô em gái có 6 người anh trai, hỏi gia đình đó có bao nhiều người? ", "74", "12", "14", "10", "Bố mẹ là 2 + 6 người anh và thêm 2 cô em gái nữa là 10", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 44: Một đoàn tàu điện chạy về hướng bắc với vận tốc 100km/h, gió thổi mạnh về hướng nam. Hỏi khói tàu bay về hướng nào?", "Tây nam", "Không về hướng nào cả", "Nam", "Bắc", "Đã là Tàu điện thì làm gì có khói phải không!", R.drawable.taudien ) );//4A
        arrayQuestion.add( new Questions( "câu 45: Người dân ở Bắc cực biết săn chim cánh cụt từ khi nào?", "Chẳng khi nào cả", "1984", "Khi cá bắt đầu khan hiếm", "Khi dụng cụ săn bắn phát triển", "Chim cánh cụt ở Nam cực! ", R.drawable.chimcanhcut ) );//4A
        arrayQuestion.add( new Questions( "câu 46: Có cách nào xếp 5 que diêm thành 11 hình tam giác không? ", "Cho thêm 1 lượt đi :v", "Bẻ nhỏ que diêm ra rồi xếp", "Có", "Không", "'11 hình tam giác' nên Xếp 3 que diêm thành 1 hình tam giác, hai que diêm còn lại xếp thành số 11 đứng phía trước hình tam giác là được!", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 47: Ở Việt Nam, một thằng mù và ba thằng điếc đi ăn phở, mỗi người ăn một tô. Mỗi tô phở là 10 ngàn đồng, hỏi ăn xong họ phải trả bao nhiêu tiền? ", "30 ngàn", "10 ngàn", "20 ngàn", "40 ngàn", " (1 +3)x10000 = 40000. Bao nhiêu người ăn thì trả tiền bấy nhiêu thôi :v", R.drawable.pho ) );//4A
        arrayQuestion.add( new Questions( "câu 48: Có bao nhiêu chữ C trong câu sau: \"Cơm, canh, cá, tất cả em đều thích\"? ", "1", "2", "3", "không có chữ C nào cả", "Chỉ có một chữ C IN HOA ở câu trên", R.drawable.quyensachkienthuc ) );//4A
        arrayQuestion.add( new Questions( "câu 49: Có 100 sinh viên đỗ đại học. Trong số đó, có 55 sinh viên chọn âm nhạc, 44 sinh viên chọn thể thao, và 20 sinh viên chọn cả 2. Hỏi có bao nhiêu sinh viên không chọn âm nhạc, cũng không chọn thể thao? ", "Không có Sinh viên nào cả!", "1", "-19???", "21", "Có 20 sinh viên chọn cả âm nhạc và thể thao, vì thế số sinh viên còn lại chọn âm nhạc là 35, và thể thao là 24. Vậy, số sinh viên không chọn cả 2 là: 100 - 20 (cả) - 35 (âm nhạc) - 24 (thể thao) = 21 sinh viên.", R.drawable.sinhvien ) );//4A
        arrayQuestion.add( new Questions( "câu 50: Vào lúc 12 giờ đêm, đồng hồ bỗng dưng Kêu 'cộc cộc' 13 tiếng, có điều gì xảy ra? ", "Báo thức kêu", "Bạn sắp gặp chuyện, vì 13 tượng trưng cho xui xẻo", "Có ma !!!!!", "Đồng hồ bị hư", "Đồng hồ đó có chức năng báo thức, bạn đặt báo thức vào lúc 12 giờ với chuông báo thức có âm thanh 'cộc cộc' ", R.drawable.donho ) );//4A


        //--------------------------------------------------------------------------------------------------------------//
        arrayTanGai = new ArrayList<>();

        arrayTanGai.add( new Questions( " Có ba cô gái cực kỳ hấp dẫn đứng gần chỗ bạn trong một buổi dạ hội. Bạn muốn làm quen. Tiếp cận thế nào đây nhỉ?", "Đến thẳng cô gái xinh nhất và nói 'Anh mời em nhảy được không?' ", "Các em nghĩ gì về việc đàn ông lớn tuổi cặp kè với những cô gái nhỏ hơn chục tuổi?", "Lại gần và hỏi, 'Em tuổi gì?'", "Anh thấy 3 bọn em xinh nhất ở đây, bọn em uống gì để anh mời?", "Ý hay đấy. Thậm chí ngay cả khi chưa có nhiều kinh nghiệm lắm thì bạn cũng có thể nhận thấy rằng các cách tiếp cận khác đều đã quá quen thuộc với những cô nàng xinh đẹp, vì họ đã quen với việc được người chàng trai tán tỉnh.", R.drawable.girl3parrty ) );//B
        arrayTanGai.add( new Questions( " Trong lúc ngồi chờ xe buýt bạn gặp một cô nàng rất dễ thương, vui tính và tỏ ra cởi mở và bạn muốn xin số. Cách tốt nhất để lấy được số điện thoại là:", "Mời nàng đi chơi vào một hôm nào đó.", "Liếc trộm số điện thoại của nàng trên vé xe bus tháng", "Nói: Cho anh số điện thoại của em được không? Sẵn bút đây!", "Hỏi xem nàng thường lui tới quán ăn nào và mời nàng đến đó ăn tối.", "Bạn làm thế hay đấy. Sợ cái gì cơ chứ? Hãy tỏ ra mình là một người đàn ông tự tin bằng cách hỏi xin thẳng số điện thoại của nàng. Đàn ông thế kỷ 21 phải thế!. Phương án B cũng an toàn nhưng khi liên lạc bạn phải mất nhiều thời gian để giải thích vì sao bạn có số cô ấy!", R.drawable.bustop ) );//c
        arrayTanGai.add( new Questions( " Lần hẹn hò đầu tiên với một cô gái. Sau khi chào hỏi, cô gái nhìn xoáy vào mắt bạn và hỏi:\"Thế anh đi xe gì đấy?\". Bạn trả lời....", "Cười và nói: \"Anh không đi xe, thường đi đâu thì mẹ anh chở anh đi\".", "Anh đi xe Babetta. Sao, em muốn đi thử à?\", cùng giọng châm biếm pha chút hài hước.", "Em không nghĩ ra câu nào hay hơn để hỏi à? Em định phỏng vấn anh đấy à?", "Nói thật bạn đang đi xe gì.", "Ở câu này a và b đều đúng. Biết cách trả lời lại một cách châm biếm, bạn chứng tỏ được khiếu hài hước của mình với cô nàng. Cũng có đôi chút ấn tượng.", R.drawable.babbeta ) );//ab
        arrayTanGai.add( new Questions( " Bạn đang dự một bữa tiệc, bạn để ý một cô gái và muốn lại bắt chuyện. Điều bạn không nên nói là... ", "'em thật xinh đẹp, em đã có gia đình hay bạn trai chưa?'", "Chào Em, anh tên Hùng, mọi người thường gọi anh là hùng đẹp trai", "Anh rất thích chiếc váy em đang mặc, có phải của nhà thiết kế....", "em thích uống loại rượi này à? anh thấy em cũng rất sành đồ uống nhỉ!", "Câu nói này chỉ thể hiện bạn là một con người nhàm chán.Mọi cô gái đều thích được khen vì thế một câu hỏi mở hay một lời khen sẽ là sự lựa chọn khôn ngoan!", R.drawable.namnuobuatiec ) );//
        arrayTanGai.add( new Questions( " Bạn vừa quen cô gái rất xinh tại quán cà phê, lại cho bạn cả số điện thoại. Bạn cũng thích nàng, tiếp cận nàng thế nào bây giờ?", " Đợi 1 2 ngày rồi gọi, nói chuyện vài phút rồi tạm biệt mà không hẹn hò gì cả.", " Đợi ba ngày rồi hẹn đi chơi vào tối hôm sau.", "Vài giờ sau gọi điện nói thích nàng và rủ nàng đi chơi vào tối đó luôn!", "Gọi cho nàng luôn để kiểm tra xem có phải số đt thật không?", "Như thế là bạn đã gửi đi được thông điệp cần thiết rồi, mà lại không tiến quá nhanh! Nếu chọn phương án D thì chẳng ngầu chút nào!", R.drawable.goidien1 ) );//b
        arrayTanGai.add( new Questions( " Trong buổi hẹn hò đầu tiên với nàng, bạn sẽ mặc gì?", "Quần Âu đen + sơ mi trắng", "Quần jean bó sát + áo thun", "Một bộ trang phục thể thao", " bộ đồ bạn ưa thích nhất", "Bạn dễ khiến cô ấy đổ với vè ngoài nam tính, lịch thiệp. Điều khiến cô ấy nghĩ bạn thật sự trân trọng buổi gặp mặt và tôn trọng cô ấy.", R.drawable.quanauaosomi ) );//a
        arrayTanGai.add( new Questions( " Bạn gái của bạn diện váy bó chẽn, để lộ thân hình, bạn của bạn nhận xét cô ấy hơi béo. Bạn sẽ nói gì với bạn của bạn?", "Ừ, để ý kĩ thì thấy béo thật!", "'Không đâu, cô ấy đáng yêu với vóc người hơi mũm mĩm'", "Quá béo chứ hơi mập gì nữa!", "công nhận cô ấy hơi béo, nhưng k sao!", "Một người đàn ông ngầu lòi thì sẽ luôn nói tốt cho người mình yêu, mặc dù không có mặt ở đó. Nhể!", R.drawable.mumum1 ) );//b
        arrayTanGai.add( new Questions( " Đang ăn tối với nàng bỗng dưng bắt gặp người yêu cũ đi cùng người yêu mới. Nên xử lý tình huống đó thể nào? ", "Giả vờ vào nhà vệ sinh và sau đó tìm cách tránh người yêu cũ", " Bạn tỏ ra thân mật hơn với nàng với mục đích làm cho cô bạn gái cũ cảm thấy ghen tị", "chào bạn gáí cũ và mời cô cùng bạn trai ngồi chung bàn.", "Làm ngơ giả vờ không quen biết", "Chuẩn, vì khi bạn làm thế, bạn gái cũ nếu thấy cũng sẽ hiểu cho bạn? Đừng cố tỏ ra thân mật với người cũ sẽ rất gượng gạo và khó xử, vì bạn đang ăn tối với bạn gái mới và bạn thực sự trân trọng mối quan hệ mới này!", R.drawable.antoilangmang ) );//d
        arrayTanGai.add( new Questions( " Bạn để ý một cô gái cùng trường, khác lớp. Bạn có fb của nàng, tin nhắn làm quen đầu tiên sẽ là..", "Chào em!", "Mình ở lớp bên, Thấy thầy toán khi nào cũng khen lớp bạn!", "Hi bạn. Cho mình làm quen nhé!", "Giả vờ ib nhầm rồi làm quen!", "Một câu hỏi mở sẽ là cách chào độc đáo, không bị rập khuôn, nhàm chán! Giả vờ ib làm quen là sự lựa chọn thiếu tinh tế nhất, ai chẳng biết là bạn cố ý!  ", R.drawable.tinnhanlamquen ) );//b
        arrayTanGai.add( new Questions( " Nên nhắn tin với Crush bao nhiêu lần/tuần ?", "3 đến 4 lần/tuần", "7 lần/tuần", " vào lúc bạn và cô ấy rảnh", "Canh crush online là ib!", "Đáp án C có vẻ ổn, nhưng cô ấy sẽ nghĩ bạn là người rảnh rỗi không có gì làm(vì khi nào online cũng thấy bạn ib đến). 3 đến 4 lần/tuần là tốt nhất vì sẽ cho cô ấy cảm giác bạn là một người có sống nguyên tắc, ", R.drawable.nhantingyeu ) );//a
        arrayTanGai.add( new Questions( " Lần đầu mạnh dạn rủ Crush đi chơi, nhưng bị từ chối. Bạn phải làm gì? ", "Giả vờ nói 'dù gì hôm nay anh cũng có việc phải hoàn thành, k sao đâu!'", "Thuyết phục cô ấy bằng mọi cách", "'Không sao, hy vọng lần sau em sẽ đổi ý'", "Không nói gì cả", "Nói thế này thì lần sau còn có cơ hội. và Crush sẽ nghĩ bạn là một người trưởng thành và lịch sự.", R.drawable.dichoivsnguoiyeu ) );//c
        arrayTanGai.add( new Questions( " Trong buổi đi chơi đầu tiên không nên nhắc đến vấn đề nào?", "Nói về bản thân", "Hỏi về việc làm của đối phương", "Đối phương thích game, nên sẽ bàn về game!", "Các vấn đề tôn giáo!", "Dù đối phương có thích chơi game đến mấy, thì buổi đi chơi đầu tiên cũng không nên nhắc đến vấn đề này! Sẽ dễ bị hiểu nhầm là nghiện game, trẻ con đấy nhé!", R.drawable.choigame ) );//c
        arrayTanGai.add( new Questions( " Trong buổi đi chơi đầu tiên nên đi đâu? ", "đi cafe/ăn", "đi xem phim", "đi bơi", "đi dạo", "Đi Cà phê là chuẩn bài nhất rồi. Nể nhất mấy thanh niên có tư tưởng rủ gái đi bơi để trôi lớp khẩu trang :)) ", R.drawable.quyensachkienthuc ) );//
        arrayTanGai.add( new Questions( " Khi cô gái từ chối cuộc hẹn bằng cách lập lờ đánh lận như:'Để em xem lịch đã nhé, em sẽ gọi lại cho anh sau'. Bạn xử lí thể nào", "ừ vậy em cứ xem lịch đi nhé!", "Em có việc gì à? Cố gắng thu xếp đi với anh cho vui nhé!", "Em bận thì thôi, thế nhé!", "Khi nào em cũng bận thế!", "Nếu con trai mà nghe rủ thế cũng khó từ chối vì thấy áy náy chứ nói gì con gái :))", R.drawable.dichoivsnguoiyeu ) );//b
        arrayTanGai.add( new Questions( " Nhắn tin với Crush một thời gian nhắn, bỗng không thấy cô ấy hồi âm. Bạn sẽ....", "Đợi một vài ngày, sau đó hỏi xem cô ấy vì sao không trả lời", "Nhắn cho đến khi cô ấy hồi âm", "dùng số khác để nhắn, thử xem cô ấy có cố tình tránh bạn không?", "Chỉ nhắn lại khi cô ấy trả lời!", "Cách này là châ thành nhất, bình tĩnh mà không vội vàng. Phải hỏi han chứ! vì bạn đang tán cô ấy mà!", R.drawable.daxem ) );//a
        arrayTanGai.add( new Questions( " Trình tự 'dứt điểm' là: ", "Cầm tay - hôn- ôm ", "Vuôt tóc - câm tay - ôm - hôn ", "Cầm tay - vuôt tóc - hôn - ôm ", " Cầm tay - vuôt tóc - ôm - hôn.", "Sắp xếp chuẩn đấy!", R.drawable.honkhi ) );//d
        arrayTanGai.add( new Questions( " Đang nhắn tin với Crush, bỗng dưng Crush đề nghị giới thiệu bạn của Crush cho bạn làm quen, bạn sẽ...", "Nhưng anh chỉ thích em!", "à ừ cảm ơn em!", "Bạn em có xinh không?", "Nếu anh quen bạn em thì em không ghen à?", "Chuẩn bài! lâu lâu cũng phải vòng vô ngôn tình thế mới hiệu quả chứ! ", R.drawable.dichoivsnguoiyeu ) );//d
        arrayTanGai.add( new Questions( " Khi bạn nhắn cả một dòng dài mà Crush chỉ 'ừ' nhẹ một cái. Cách 'tốt nhất' sẽ là?", "Trả lời Ừ giống cô ấy", "Kiếm một chủ đề nào đó hay hơn để trò chuyện", "Không nhắn nữa rồi đợi vài hôm sau nhắn lại", "Lặp lại chủ đề cũ", "Đôi khi kiếm chủ đề mới thì có thể cuộc nói chuyện sẽ vui, khả quan hơn. Nhưng trong trường hợp cô ấy chỉ 'ừ' thì hẳn là cô ấy không có hứng nói chuyện với bạn lúc đó. Đừng cố gắng gượng ép việc tiếp diễn câu chuyện", R.drawable.umeessss ) );//c
        arrayTanGai.add( new Questions( " Bạn hẹn đi chơi với một cô gái mà mình rất kết. Bạn chưa biết là cô ấy có thích mình hay không, vậy làm thế nào để biết bây giờ?", "Chủ động hôn cô ấy để dò phản ứng.", " Hỏi thẳng luôn: 'Anh có phải là mẫu đàn ông em thích không?'", "Chìa tay ra xem nàng có đưa tay cho bạn nắm không.", "Nói là 'Em có biết là em đã làm tâm hồn anh xao động không?' nửa đùa nửa thật", "Mấy cách kia không tồi nhưng đây vẫn là lựa chọn sáng suốt nhất. Với cách nói nửa đùa nửa thật như vậy, bạn sẽ không cảm thấy mất mặt khi bị từ chối!", R.drawable.quyensachkienthuc ) );//d
        arrayTanGai.add( new Questions( " Lần đi chơi đầu tiên với bạn gái. Bạn cảm thấy cô ấy cũng thích mình nhưng không chắc. Bạn muốn nắm tay nàng, nhưng làm thế nào để báo hiệu nàng...", "Chạm nhẹ vào tay nàng, nếu không phản ứng thì nắm luôn!", "Bảo nàng nhắm mắt vào, rồi nắm tay", "'Em có phiền nếu anh nắm tay không?'", "'Em có thích anh như anh thích em không?'", "Đúng đấy, cứ phải thử xem phản ứng thế nào đã. Sỗ sàng quá có khi bị phản dame. Câu D cũng chuẩn, nhưng nếu cô hỏi: 'anh yêu em đến mức nào rồi, mua cho em SH được không?' thì méo mặt.", R.drawable.camtaygai ) );//a
        //--------------------------

        arrayToan = new ArrayList<>();

        arrayToan.add( new Questions( "Bạn cầm một ít bánh đi sinh nhật bạn thân, trên đường bạn phải đi qua 7 cái cầu .Mỗi lần qua cầu bạn phải nộp cho người giữ cầu 1/2 số bánh quy của bạn và người giữ cầu trả lại cho bạn 1 cái . Vậy bạn cần phải đem theo bao nhiêu cái bánh , để khi đến được nhà người thân số bánh quy còn lại là 2 cái ???", "2", "5", "14", "7", "Dù bạn có đi qua bao nhiêu cái cầu thì chỉ cần mang theo 2 cái bánh!", R.drawable.banh ) );//a
        arrayToan.add( new Questions( "Có 2 đồng xu trên bàn, tổng giá trị là 15 đồng. Trong đó, một đồng không mang giá trị 5. Hỏi đó là những đồng xu mệnh giá nào?", "11 và 4", "7 và 8", "6 và 9", "5 và 10", "Đồng tiền không mang giá trị 5 là đồng 10đ. Đồng còn lại là đồng 5đ", R.drawable.dongxu ) );//d
        arrayToan.add( new Questions( "8, 20, 44, 92, …", "188", "140", "104", "192", " 20 - 8 = 12 và 44 - 20 = 24. nên số cuối cùng phải bằng (92 - 44)x2 + 92 = 188", R.drawable.quyensachkienthuc ) );//a
        arrayToan.add( new Questions( "Lan có một quyển sách dày 120 trang. Nhưng vì để lâu ngày nên bị mọt ăn mất một số trang. Các trang bị mọt ăn là 18, 32, 81 và 105. Hỏi quyển sách của lan còn bao nhiêu trang ?", "116", "114", "112", "110", "Mọt ăn 4 trang, có nghĩa là ăn 4 tờ ==> 8 trang. 120 - 8 = 112 trang!", R.drawable.sachbianmon ) );//c
        arrayToan.add( new Questions( "Một người đi câu cá, anh ta câu được 6 con không đầu, 9 con không đuôi và 8 con một nửa. Hỏi anh ta câu được bao nhiêu con ?", "Không câu được con nào", "7", "1", "3", "Không câu được con nào", R.drawable.xotrong ) );//a
        arrayToan.add( new Questions( "Huy đầu tư chứng khoáng, mỗi tháng số tiền sinh lãi gấp đôi. sau 1 năm số tiền lên đến 100 triệu. Vậy khi nào Huy có số tiền là 50 triệu?", "tháng 6 ", " tháng 10", "tháng 5", "tháng 11", "Tới tháng 12 thì ông ta có 100 triệu đôla. Cứ sau mỗi tháng số tiền lại sinh lãi gấp đôi, nên tới tháng 11 ông ta có số tiền vừa bằng một nửa số tiền thu được vào tháng thứ 12, tức là 50 triệu đôla", R.drawable.tiendsjkds ) );//d
        arrayToan.add( new Questions( "Cũng trong một cuộc đua, bạn vừa chạy qua người cuối cùng. Vậy bạn đang ở vị trí nào?", "Gần cuối ", "Cuối cùng", "Click để thêm lượt chơi!", "chả ở vị trí nào cả", "Nếu bạn chạy qua người cuối cùng mà bạn đứng vị trí cuối cùng, thì cái người 'Cuối cùng' mà bạn vừa chạy qua sẽ đứng vị trí thứ mấy?  ", R.drawable.chayduaaa ) );//b
        arrayToan.add( new Questions( "32 27 48 19 \n" + "34 32 56  ?\n", "40 ", "30", "54", "45", "cột đầu tiên số dưới lớn hơn số trên = 2 , và tương tự hàng thứ 2 , thứ 3 , thứ 4 là: 5, 8 và 11. Nên ô trống phải là 19+11", R.drawable.quyensachkienthuc ) );//
        arrayToan.add( new Questions( "Có 100 sinh viên đỗ đại học. Trong số đó, có 55 sinh viên chọn âm nhạc, 44 sinh viên chọn thể thao, và 20 sinh viên chọn cả 2. Hỏi có bao nhiêu sinh viên không chọn âm nhạc, cũng không chọn thể thao? ", "Không có Sinh viên nào cả!", "1", "-19???", "21", "Có 20 sinh viên chọn cả âm nhạc và thể thao, vì thế số sinh viên còn lại chọn âm nhạc là 35, và thể thao là 24. Vậy, số sinh viên không chọn cả 2 là: 100 - 20 (cả) - 35 (âm nhạc) - 24 (thể thao) = 21 sinh viên.", R.drawable.sinhvien ) );//d
        arrayToan.add( new Questions( "Ở Việt Nam, một thằng mù và ba thằng điếc đi ăn phở, mỗi người ăn một tô. Mỗi tô phở là 10 ngàn đồng, hỏi ăn xong họ phải trả bao nhiêu tiền? ", "30 ngàn", "10 ngàn", "20 ngàn", "40 ngàn", " (1 +3)x10000 = 40000. Bao nhiêu người ăn thì trả tiền bấy nhiêu thôi :v", R.drawable.pho ) );//c
        arrayToan.add( new Questions( "1+1+1+1+1\n" + "       1+1+1+1+1\n" + "       1+1x0+1 = ?\n ", "30", "12", "13", "1", "Không có dấu cộng ở cuối dòng thứ nhất và thứ hai. Như vậy, ta được phương trình:\n" + "\n" + "1 +1 +1 +1 +11 +1 +1 +1 +11 +1 x 0 +1 = 30", R.drawable.quyensachkienthuc ) );//a
        arrayToan.add( new Questions( "Một Người đi Lên cầu thang bộ dài 40 bậc bằng cách tiến một bước rồi lùi một bước. Hỏi sau bao lâu người đó đi hết cầu thang? Biết rằng trung bình mỗi bước đi hết 5 giây ", "205s", "200s", "không bao giờ bước lên bậc thang thứ 2", "300s", "Đầu tiên là bước xuôi, sau đó quay người lại để bước lùi => mất 40x5=200s", R.drawable.cauthang ) );//
        arrayToan.add( new Questions( "Tìm số khác nhau với các số còn lại: 64, 100, 125, 343", " 64", "343", "125", "100", "64 = 4 mũ 3, 125 = 5 mũ 3 , 343 = 6 mũ 3 nên số 100 khác với những số còn lại", R.drawable.quyensachkienthuc ) );//d
        arrayToan.add( new Questions( "5 25 29 85 89.?.", "134", "145", "126", "95", "Số cần tìm là 145. Quy luật của dãy số như sau: 5×5=25; (2×2)+(5×5)=29;  (2×2)+(9×9)=85; (8×8)+(5×5)=89; (8×8)+(9×9)=145", R.drawable.quyensachkienthuc ) );//b
        arrayToan.add( new Questions( "Tổng số tuổi của bố và con là 66. Tuổi của bố gồm những số giống tuổi của con nhưng đảo ngược. Hỏi có mấy trường hợp có thể xảy ra?", "2 ", "3", "4", "5", "TH1:BỐ 60 CON 6; TH2:BỐ 42 CON 24; TH3:BỐ 51 CON 15; ", R.drawable.number3 ) );//b
        arrayToan.add( new Questions( "19  20  21  ?  ?  26  28  32  33  40", "36 và 38 ", "22 và 24", "23 và 24", "25 và 27", "Dãy số này gồm 2 dãy con đan xen nhau: Dãy con thứ nhất bắt đầu từ số 19, các số sau lớn hơn số trước lần lượt là 2, 3, 4, 5 đơn vị. Vậy dãy thứ nhất sẽ là: 19, 21, 24, 28, 33. Dãy con thứ hai bắt đầu từ số 20, các số sau lớn hơn số trước lần lượt là 2, 4, 6, 8 đơn vị. Vậy dãy thứ hai sẽ là: 20, 22, 26, 32, 40.", R.drawable.quyensachkienthuc ) );//
        arrayToan.add( new Questions( "Số nào khác với 3 số còn lại?", "32418", "84129", "47632", "36119", "Quy luật cần tìm của những số trên: 3 chữ số đầu là bình phương của 2 số cuối. Ví dụ: 324 = 18x18; 841 = 29x29.\n" + "\n" + "Số không tuân theo quy luật là 47632.", R.drawable.quyensachkienthuc ) );//c
        arrayToan.add( new Questions( " 10  10  9  7  7  ?  4  4  3  1", "5 ", "6", "8", "9", "Dãy số trên tuân theo quy luật:\n" + "\n" + "10,10: 10-1 = 9. 10-3 = 7\n" + "\n" + "7,7: 7-1 = 6. 7-3 = 4\n" + "\n" + "4,4: 4-1 = 3. 4-3 = 1\n" + "\n" + "1,1\n" + "\n" + "Vậy đáp án cần tìm là số 6.", R.drawable.number6 ) );//b
        arrayToan.add( new Questions( "16  23  19  19  22  15  25  ?", "11 ", "34", "23", "48", "Dãy số trên tuân theo quy luật:\n" + "\n" + "16 + 3 = 19\n" + "\n" + "23 - 4  = 19\n" + "\n" + "19 + 3 = 22\n" + "\n" + "19 - 4 = 15\n" + "\n" + "22 + 3 = 25\n" + "\n" + "15 - 4 = 11\n" + "\n" + "Vậy số cần tìm là 11", R.drawable.number1111 ) );//a


    }


    public void setQuestion(int s) {

        switch (s) {
            case 1:
                Random random = new Random();
                int randomNumber = random.nextInt(50);

                txtQuestion.setText( arrayQuestion.get( numberQuestion ).getCauhoi() );
                btnA.setText( arrayQuestion.get( numberQuestion ).getDapanA() );
                btnB.setText( arrayQuestion.get( numberQuestion ).getDapanB() );
                btnC.setText( arrayQuestion.get( numberQuestion ).getDapanC() );
                btnD.setText( arrayQuestion.get( numberQuestion ).getDapanD() );


                btnA.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 4 || numberQuestion == 10 || numberQuestion == 16 || numberQuestion == 22 || numberQuestion == 29 || numberQuestion == 36 || numberQuestion == 44 || numberQuestion == 47 || numberQuestion == 49) && numberLeft > 0) {

                            if (numberQuestion == 49 && numberLeft > 0) {
                                //ting ting ting chuc mung tra loi het cau hoi roi
                                Intent intentWin = new Intent( QuestionActivity.this, WinActivity.class );
                                startActivity( intentWin );
                            } else {//dung nhung khong phai dap an cuoi cung
                                Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                                startActivity( intent );
                                numberQuestion++;

                            }
                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {//chỉ được phép trừ xuống 0(sau dấu >)
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }


                        }


                    }//onclick
                } );

                btnB.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 0 || numberQuestion == 2 || numberQuestion == 5 || numberQuestion == 9 || numberQuestion == 12 || numberQuestion == 14 || numberQuestion == 18 || numberQuestion == 21 || numberQuestion == 23 || numberQuestion == 27 || numberQuestion == 30 || numberQuestion == 35 || numberQuestion == 41 || numberQuestion == 43) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnC.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 1 || numberQuestion == 3 || numberQuestion == 8 || numberQuestion == 11 || numberQuestion == 20 || numberQuestion == 24 || numberQuestion == 31 || numberQuestion == 32 || numberQuestion == 34 || numberQuestion == 37 || numberQuestion == 38 || numberQuestion == 40 || numberQuestion == 45) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnD.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 6 || numberQuestion == 7 || numberQuestion == 13 || numberQuestion == 15 || numberQuestion == 17 || numberQuestion == 19 || numberQuestion == 25 || numberQuestion == 26 || numberQuestion == 28 || numberQuestion == 33 || numberQuestion == 39 || numberQuestion == 42 || numberQuestion == 46 || numberQuestion == 48) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );
                txtNumberLeft.setText( numberLeft + "" );


                break;


            case 2:
                txtQuestion.setText( arrayToan.get( numberQuestion ).getCauhoi() );
                btnA.setText( arrayToan.get( numberQuestion ).getDapanA() );
                btnB.setText( arrayToan.get( numberQuestion ).getDapanB() );
                btnC.setText( arrayToan.get( numberQuestion ).getDapanC() );
                btnD.setText( arrayToan.get( numberQuestion ).getDapanD() );

                btnA.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 0 || numberQuestion == 2 || numberQuestion == 4 || numberQuestion == 10 || numberQuestion == 18) && numberLeft > 0) {

                            if (numberQuestion == 18 && numberLeft > 0) {
                                //ting ting ting chuc mung tra loi het cau hoi roi
                                Intent intentWin = new Intent( QuestionActivity.this, WinActivity.class );
                                startActivity( intentWin );
                            } else {//dung nhung khong phai dap an cuoi cung
                                Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                                startActivity( intent );
                                numberQuestion++;

                            }
                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {//chỉ được phép trừ xuống 0(sau dấu >)
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }


                        }


                    }//onclick
                } );

                btnB.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 2 || numberQuestion == 7 || numberQuestion == 11 || numberQuestion == 13 || numberQuestion == 14 || numberQuestion == 15 || numberQuestion == 17) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnC.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 3 || numberQuestion == 16) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnD.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 1 || numberQuestion == 5 || numberQuestion == 6 || numberQuestion == 8 || numberQuestion == 9 || numberQuestion == 12) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;

                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );
                txtNumberLeft.setText( numberLeft + "" );
                break;


            case 3:
                txtQuestion.setText( arrayTanGai.get( numberQuestion ).getCauhoi() );
                btnA.setText( arrayTanGai.get( numberQuestion ).getDapanA() );
                btnB.setText( arrayTanGai.get( numberQuestion ).getDapanB() );
                btnC.setText( arrayTanGai.get( numberQuestion ).getDapanC() );
                btnD.setText( arrayTanGai.get( numberQuestion ).getDapanD() );

                btnA.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 2 || numberQuestion == 3 || numberQuestion == 5 || numberQuestion == 9 || numberQuestion == 12 || numberQuestion == 14 || numberQuestion == 19) && numberLeft > 0) {

                            if (numberQuestion == 19 && numberLeft > 0) {
                                //ting ting ting chuc mung tra loi het cau hoi roi
                                Intent intentWin = new Intent( QuestionActivity.this, WinActivity.class );
                                startActivity( intentWin );
                            } else {//dung nhung khong phai dap an cuoi cung
                                Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                                startActivity( intent );
                                numberQuestion++;

                            }
                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {//chỉ được phép trừ xuống 0(sau dấu >)
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }


                        }


                    }//onclick
                } );

                btnB.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 0 || numberQuestion == 2 || numberQuestion == 4 || numberQuestion == 6 || numberQuestion == 8 || numberQuestion == 13) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnC.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 1 || numberQuestion == 10 || numberQuestion == 11 || numberQuestion == 17) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnD.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 7 || numberQuestion == 15 || numberQuestion == 16 || numberQuestion == 18) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );
                txtNumberLeft.setText( numberLeft + "" );
                break;
            default:
                txtQuestion.setText( arrayQuestion.get( numberQuestion ).getCauhoi() );
                btnA.setText( arrayQuestion.get( numberQuestion ).getDapanA() );
                btnB.setText( arrayQuestion.get( numberQuestion ).getDapanB() );
                btnC.setText( arrayQuestion.get( numberQuestion ).getDapanC() );
                btnD.setText( arrayQuestion.get( numberQuestion ).getDapanD() );

                btnA.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 4 || numberQuestion == 10 || numberQuestion == 16 || numberQuestion == 22 || numberQuestion == 29 || numberQuestion == 36 || numberQuestion == 44 || numberQuestion == 47 || numberQuestion == 49) && numberLeft > 0) {

                            if (numberQuestion == 49 && numberLeft > 0) {
                                //ting ting ting chuc mung tra loi het cau hoi roi
                                Intent intentWin = new Intent( QuestionActivity.this, WinActivity.class );
                                startActivity( intentWin );
                            } else {//dung nhung khong phai dap an cuoi cung
                                Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                                startActivity( intent );
                                numberQuestion++;

                            }
                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {//chỉ được phép trừ xuống 0(sau dấu >)
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }


                        }


                    }//onclick
                } );

                btnB.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 0 || numberQuestion == 2 || numberQuestion == 5 || numberQuestion == 9 || numberQuestion == 12 || numberQuestion == 14 || numberQuestion == 18 || numberQuestion == 21 || numberQuestion == 23 || numberQuestion == 27 || numberQuestion == 30 || numberQuestion == 35 || numberQuestion == 41 || numberQuestion == 43) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnC.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 1 || numberQuestion == 3 || numberQuestion == 8 || numberQuestion == 11 || numberQuestion == 20 || numberQuestion == 24 || numberQuestion == 31 || numberQuestion == 32 || numberQuestion == 34 || numberQuestion == 37 || numberQuestion == 38 || numberQuestion == 40 || numberQuestion == 45) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );

                btnD.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((numberQuestion == 6 || numberQuestion == 7 || numberQuestion == 13 || numberQuestion == 15 || numberQuestion == 17 || numberQuestion == 19 || numberQuestion == 25 || numberQuestion == 26 || numberQuestion == 28 || numberQuestion == 33 || numberQuestion == 39 || numberQuestion == 42 || numberQuestion == 46 || numberQuestion == 48) && numberLeft > 0) {
                            Intent intent = new Intent( QuestionActivity.this, KnowLedgeActivity.class );
                            startActivity( intent );
                            numberQuestion++;


                        } else {
                            showToast( "SAI" );
                            if (numberLeft > 0) {
                                numberLeft--;

                                txtNumberLeft.setText( numberLeft + " " );
                            }

                            if (numberLeft == 0) {//numberleft = 0
                                Intent intent = new Intent( QuestionActivity.this, LoseActivity.class );
                                startActivity( intent );
                            }
                        }
                    }//onclick
                } );
                txtNumberLeft.setText( numberLeft + "" );
                break;
        }


    }

    public void showToast(String text) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate( R.layout.toast_layout, (ViewGroup) findViewById( R.id.toast_root ) );
        TextView toastText = layout.findViewById( R.id.toast_text );
        ImageView toastImage = layout.findViewById( R.id.toast_image );
        toastText.setText( text );
        toastImage.setImageResource( R.drawable.trollface );
        Toast toast = new Toast( getApplicationContext() );
        toast.setGravity( Gravity.CENTER, 0, 0 );
        toast.setDuration( Toast.LENGTH_SHORT );
        toast.setView( layout );
        toast.show();
    }
}


