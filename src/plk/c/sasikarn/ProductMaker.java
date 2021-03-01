package plk.c.sasikarn;

public enum ProductMaker {
	  /** 「商品メーカー」指定なし。 */
	  UNSPECIFIED("指定なし"),
	  /** 「商品メーカー」パナソニック。 */
	  PANASONIC("パナソニック"),
	  /** 「商品メーカー」ソニー。 */
	  SONY("ソニー"),
	  /** 「商品メーカー」シャープ。 */
	  SHARP("シャープ");

	  /**  商品メーカー名 */
	  private String makerName;

	  /**
	   * 商品メーカー名を基に商品メーカーを生成します。
	   *
	   * @param makerName 商品メーカー名
	   */
	  private ProductMaker(String makerName) {
	    this.makerName = makerName;
	  }

	  /**
	   * 商品メーカー名を取得します。
	   * @return 商品メーカー名
	   */
	  public String getMakerName() {
	    return this.makerName;
	  }
	}