package plk.c.sasikarn;

public enum ProductGenre {
	  /** 「商品ジャンル」指定なし。コード値は0です。 */
	  UNSPECIFIED(0, "指定なし"),
	  /** 「商品ジャンル」時計。コード値は1です。 */
	  CLOCK(1, "時計"),
	  /** 「商品ジャンル」電子機器。コード値は2です。 */
	  ELECTRONICS(2, "電子機器"),
	  /** 「商品ジャンル」携帯。コード値は3です。 */
	  MOBILE_PHONE(3, "携帯");

	  /** 商品ジャンルコード */
	  private int genreCode;
	  /** 商品ジャンル名 */
	  private String genreName;

	  /**
	   * 商品ジャンルコードと商品ジャンル名を基に商品ジャンルを生成します。
	   * @param genreCode 商品ジャンルコード
	   * @param genreName 商品ジャンル名
	   */
	  private ProductGenre(int genreCode, String genreName) {
	    this.genreCode = genreCode;
	    this.genreName = genreName;
	  }

	  /**
	   * 商品ジャンルコードを取得します。
	   * @return 商品ジャンルコード
	   */
	  public int getGenreCode() {
	    return this.genreCode;
	  }

	  /**
	   * 商品ジャンル名を取得します。
	   * @return 商品ジャンル名
	   */
	  public String getGenreName() {
	    return this.genreName;
	  }
	}